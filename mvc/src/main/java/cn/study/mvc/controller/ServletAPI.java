package cn.study.mvc.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class ServletAPI {
    @GetMapping("/api")
    public String api(HttpServletRequest request, HttpSession session) {
        session.setAttribute("JSESSIONID", "123123");
        request.setAttribute("request", "requestValue");
        return "111";
    }
}
