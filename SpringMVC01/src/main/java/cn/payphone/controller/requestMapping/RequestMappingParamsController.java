package cn.payphone.controller.requestMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/params")
public class RequestMappingParamsController {

    // 必须携带username这个参数
    @RequestMapping(path = "/need1", params = {"username"})
    public String t1() {
        return "username is ok";
    }

    // 不能带username这个参数
    @RequestMapping(path = "/need2", params = {"!username"})
    public String t2() {
        return "Not username params";
    }

    // 不能带username这个参数
    @RequestMapping(path = "/need3", params = {"username!=123"})
    public String t3() {
        return "username can't equals 123";
    }

    // username要为3 注意是一个 ”=“ 具体用法不记得就看源码注释！
    @RequestMapping(path = "/need4", params = {"username=123"})
    public String t4() {
        return "username equals 123";
    }

    @RequestMapping(path = "/need5", params = {"age=16", "name!=liujiawei"})
    public String t5() {
        return "mut1";
    }

    // Parameter conditions "age>16, name!=liujiawei" not met for actual request parameters: age={16}, name={liu}
    // 不能大于小于号
    @RequestMapping(path = "/need6", params = {"age>16", "name!=liujiawei"})
    public String t6() {
        return "mut2";
    }

}
