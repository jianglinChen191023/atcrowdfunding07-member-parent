package com.atguigu.crowd.handler;

import com.atguigu.crowd.api.RedisRemoteService;
import com.atguigu.crowd.config.ShortMessageProperties;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
            if(ResultEntity.SUCCESS.equals(sendMessageResultEntity.getResult())) {
                // 3. 成功: 将验证码存入 Redis
                String code = sendMessageResultEntity.getData();
                String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;
                ResultEntity<String> saveCodeResultEntity = redisRemoteService.setRedisKeyValueRemoteWithTimeout(key, code, 15, TimeUnit.MINUTES);
                if(ResultEntity.SUCCESS.equals(saveCodeResultEntity.getResult())) {
                    return ResultEntity.successWithoutData();
                } else {
                    return saveCodeResultEntity;
                }
            } else {
                return sendMessageResultEntity;
            }
        } catch (Exception e){
            return ResultEntity.failed(e.getMessage());
        }
    }
}