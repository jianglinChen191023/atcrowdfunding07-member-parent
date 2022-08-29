package com.atguigu.crowd.handler;

import com.atguigu.crowd.api.MySQLRemoteService;
import com.atguigu.crowd.api.RedisRemoteService;
import com.atguigu.crowd.config.ShortMessageProperties;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.vo.MemberVO;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈江林
 * @date 2022/8/29 11:21
 */
@Controller
public class MemberHandler {

    @Autowired
    private ShortMessageProperties shortMessageProperties;

    @Autowired
    private RedisRemoteService redisRemoteService;

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    /**
    /**
     * 执行注册
     *
     * @param memberVO
     * @param modelMape
     * @return
     */
    @RequestMapping("/auth/do/member/register")
    public String register(MemberVO memberVO, ModelMap modelMape) {
        // 1. 获取用户输入的手机号码
        String phoneNum = memberVO.getPhoneNum();

        // 2. 拼 Redis 中存储验证码的 Key
        String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;

        // 3. 从 Redis 读取 Key 对应的 Value
        ResultEntity<String> resultEntity = redisRemoteService.getRedisKeyValueByKey(key);

        // 4. 检查查询操作是否有效
        String result = resultEntity.getResult();
        if (ResultEntity.FAILED.equals(result)) {
            modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, resultEntity.getMessage());
            return "member-reg";
        }

        String redisCode = resultEntity.getData();

        if (redisCode == null) {
            // MESSAGE_CODE_NOT_EXISTS = 验证码已过期!请检查手机号码是否正确或重新发送!
            modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_NOT_EXISTS);
            return "member-reg";
        }

        // 5. 如果从 Redis 能够查询到 Value 则比较表单的验证码和 Redis 的验证码
        String formCode = memberVO.getCode();

        if (!Objects.equals(formCode, redisCode)) {
            // MESSAGE_CODE_INVALID = 验证码不正确!
            modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_INVALID);
            return "member-reg";
        }

        // 6. 如果验证码一致则从 Redis 删除
        redisRemoteService.removeRedisKeyRemote(key);

        // 7. 执行密码加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String userpswdBeforeEncode = memberVO.getUserpswd();
        String userpswdAfterEncode = bCryptPasswordEncoder.encode(userpswdBeforeEncode);

        memberVO.setUserpswd(userpswdAfterEncode);
        // 8. 执行保存
        // 8.1 创建空的 memberPO 对象
        MemberPO memberPO = new MemberPO();

        // 8.2 复制属性
        BeanUtils.copyProperties(memberVO, memberPO);

        // 8.3 调用远程的方法
        ResultEntity<String> saveMemberResultEntity = mySQLRemoteService.saveMember(memberPO);
        if (ResultEntity.FAILED.equals(saveMemberResultEntity.getResult())) {
            modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, saveMemberResultEntity.getMessage());
            return "member-reg";
        }

        // 使用重定向避免刷新浏览器导致重新执行注册流程
        return "redirect:/auth/member/to/login/page";
    }

    /**
     * 发送短信验证码
     *
     * @param phoneNum 手机号码
     * @return
     */
    @ResponseBody
    @RequestMapping("/auth/member/send/short/message.json")
    public ResultEntity<String> sendMessage(
            @RequestParam("phoneNum") String phoneNum) {
        try {
            // 1. 发送验证码
            ResultEntity<String> sendMessageResultEntity = CrowdUtil.sendShortMessage(
                    shortMessageProperties.getAppCode(),
                    shortMessageProperties.getTemplateId(),
                    shortMessageProperties.getHost(),
                    shortMessageProperties.getPath(),
                    shortMessageProperties.getMethod(),
                    phoneNum
            );

            // 2. 判断发送结果
            if (ResultEntity.SUCCESS.equals(sendMessageResultEntity.getResult())) {
                // 3. 成功: 将验证码存入 Redis
                String code = sendMessageResultEntity.getData();
                String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;
                ResultEntity<String> saveCodeResultEntity = redisRemoteService.setRedisKeyValueRemoteWithTimeout(key, code, 15, TimeUnit.MINUTES);
                if (ResultEntity.SUCCESS.equals(saveCodeResultEntity.getResult())) {
                    return ResultEntity.successWithoutData();
                } else {
                    return saveCodeResultEntity;
                }
            } else {
                return sendMessageResultEntity;
            }
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }
}