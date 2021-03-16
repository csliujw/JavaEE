package cn.payphone.controller.requestMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模糊匹配功能
 * URL地址可以写模糊的通配符
 * ？ 能替代任意一个字符
 * * 能替代任意多个字符，和一层路径
 * ** 能替代多层路径
 */
@RestController
@RequestMapping("/ant")
public class AntController {

    @RequestMapping("/antTest01")
    public String antTest1() {
        return "antTest01";
    }

    // antTest01 antTest02 antTest03 都是走这个方法
    // antTest011就不行了，antTest0?中的问号只能匹配一个字符
    // 有精确的肯定优先匹配精确的
    @RequestMapping("/antTest0?")
    public String antTest2() {
        return "antTest?";
    }

    // 先匹配精确一点的antTest0? 在匹配模糊一点的antTest0*
    @RequestMapping("/antTest0*")
    public String antTest3() {
        return "antTest0*";
    }

    // * 匹配一层路径
    @RequestMapping("/a/*/antTest01")
    public String antTest4() {
        return "一层路径";
    }

    // ** 匹配多层路径
    @RequestMapping("/a/**/antTest01")
    public String antTest5() {
        return "两层路径";
    }
}
