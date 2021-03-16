package cn.payphone.controller.source;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * debug 看 DispatcherServlet的源码
 */
@Controller
public class DispatcherServletSource {

    @RequestMapping("/success")
    public String myFirstRequest() {
        System.out.println("请求收到了");
        return "success";
    }
}
