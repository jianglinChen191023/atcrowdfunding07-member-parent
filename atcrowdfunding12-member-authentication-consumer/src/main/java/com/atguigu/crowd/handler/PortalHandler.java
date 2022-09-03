package com.atguigu.crowd.handler;

import com.atguigu.crowd.api.MySQLRemoteService;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/8/28 22:14
 */
@Controller
public class PortalHandler {

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    /**
     * 显示首页
     *
     * @return
     */
    @RequestMapping("/")
    public String toPortalPage(Model model) {
        // 查询首页要显示的数据
        ResultEntity<List<PortalTypeVO>> resultEntity = mySQLRemoteService.getPortalTypeProjectDataRemote();

        // 检查查询结果
        String result = resultEntity.getResult();
        if(ResultEntity.SUCCESS.equals(result)) {
            // 获取查询结果数据
            List<PortalTypeVO> list = resultEntity.getData();

            // 存入模型中
            // ATTR_NAME_PORTAL_DATA = portal_data
            model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_DATA, list);
        }

        return "portal";
    }

}