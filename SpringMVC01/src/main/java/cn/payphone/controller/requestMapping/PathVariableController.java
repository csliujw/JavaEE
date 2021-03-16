package cn.payphone.controller.requestMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PathVariableController {

    // {id}是占位符
    @RequestMapping("/user/{id}")
    /* @PathVariable 获取请求路径中占位符的值*/
    public String pathVariableTest(@PathVariable("id") String id) {
        ArrayList<Object> objects = new ArrayList<>();
        return id;
    }

    /* 占位符的名称和方法中的参数名称一致就不用在注解里设置别名*/
    @RequestMapping("/user/info/{id}")
    public String pathVariableTest2(@PathVariable String id) {
        return id;
    }

    /* 占位符的名称和方法中的参数名称不一致就要在注解里设置*/
    @RequestMapping("/user/infos/{id}")
    public String pathVariableTest3(@PathVariable("id") String ids) {
        return ids;
    }
}