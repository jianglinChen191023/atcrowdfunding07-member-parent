package com.atguigu.crowd.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 陈江林
 * @date 2022/8/28 22:14
 */
@Controller
public class PortalHandler {

    /**
     * 显示首页
     *
     * @return
     */
    @RequestMapping("/")
    public String toPortalPage() {
        // 这里实际开发中需要获取数据

        return "portal";
    }

}