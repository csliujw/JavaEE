package cn.payphone.controller;

import cn.payphone.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class RequestParameterController {
    /**
     * SpringMVC如何获取请求带来的各种信息？
     * 默认方式获取请求参数：
     * 直接给方法入参写一个和请求参数名相同的变量。这个变量就来接受请求参数的值。
     *
     * @RequestParam 获取请求参数；参数默认必须带的
     * - @RequestParam 相当于 String username = request.getParameter("user")
     * - value：指定要获取的参数的key
     * - required：这个参数是否必须的
     * - defaultValue：参数默认值
     * =================================================================
     * @PathVariable("user") 是获取路径中的值！！
     * @RequestParam("user") 是获取？后面的值！！
     * =================================================================
     * @RequestHeader 获取请求头中某个key的值。
     * - request.getHeader("User-Agent")
     * - @RequestHeader("User-Agent") String MyUserAgent 写在方法参数上
     * - 等同于 String MyUserAgent = request.getHeader("User-Agent")
     * - 这个注解里也是三个属性
     * - value
     * - required
     * - defaultValue
     * =================================================================
     * @CookieValue：获取某个cookie的值 - 以前获取某个cookie
     * - Cookie[] cookies = request.getCookies();
     * - for (Cookie c: cookies){
     * if(c.getName().euqals("JSESSIONID")){
     * String ret = c.getValue()
     * }
     * }
     * - 现在 @CookieValue("JSESSIONID") String jid
     * <p>
     * - 这个注解里也是三个属性
     * - value
     * - required
     * - defaultValue
     * =================================================================
     * POJO 自动为POJO进行复制。只要参数的key和POJO的字段名称一致即可
     * - 将POJO中的每一个属性，从request参数中尝试获取出来，并封装即可。
     * - 可以级联复制 address.province
     * =================================================================
     * 使用Servlet原生API
     * // 这样即可
     * xxx methodName(HttpSession session){
     * <p>
     * }
     * =================================================================
     * 提交数据可能乱码
     * - 请求乱码
     * - GET请求：改server.xml 在8080端口处 URIEncoding="UTF-8"
     * - POST 请求
     * - 在第一次获取请求参数之前设置
     * - request.setCharacterEncoding("UTF-8")
     * - 自己写一个filter：springmvc有这个filter
     * - 响应乱码
     * response.setContentType("text/html;charset=utf-8")
     * 使用SpringMVC前端控制器 写完就直接写字符编码过滤器
     * Tomcat一装上，上手就是server.xml的8080处添加URIEncoding=”UTF-8“
     * 注意！！字符编码Filter要在其他Filter之前！！我们要在
     */

    @ResponseBody
    @RequestMapping("/params/default")
    public String defaultGet(String username) {
        return username;
    }

    // 相当于 String username = request.getParameter("user")
    @ResponseBody
    @RequestMapping("/params/handle2")
    public String handle(@RequestParam("user") String username) {
        return username;
    }

    @ResponseBody
    @RequestMapping("/params/getSession")
    public String getSession(@SessionAttribute("user") String user) {
        return String.format("get session :{%s}", user);
    }

    @RequestMapping("/params/setSession")
    public String setSession(HttpSession session) {
        session.setAttribute("user", "liujiawe");
        return "redirect:/params/getSession";
    }

    @ResponseBody
    @RequestMapping("/params/pojo")
    public User pojo(User user) {
        return user;
    }
}
