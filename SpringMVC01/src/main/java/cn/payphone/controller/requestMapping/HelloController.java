package cn.payphone.controller.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;

/**
 * 1、运行流程
 * 1）客户端点击链接发送 xxx/ 请求
 * 2）来到tomcat服务器
 * 3）SpringMVC的前端控制器收到所有请求
 * 4）来看请求地址和@RequestMapping标注的那个匹配，来找到到底使用那个类的那个方法来处理请求。
 * 5）前端控制器找到了目标处理器类和目标方法，直接利用 返回执行目标方法
 * 6）方法执行完成后会有一个返回值，SpringMVC认为这个返回值就是要去的页面地址
 * 7）拿到方法返回值后；用视图解析器进行拼串得到完整的页面地址
 * 8）拿到页面地址值，前端控制器帮我们转发到页面。
 * <p>
 * 2、@RequestMapping
 * 告诉spring mvc这个方法用来处理什么请求。。
 * 这个/是可以省略的，即时省略了，也是默认从当前项目开始。
 * 加上/比较好
 * <p>
 * 3、@RequestMapping的使用
 * - Spring MVC使用@RequestMapping注解为控制器指定可以处理那些url请求
 * - 在控制器的类定义及方法定义处都可标准
 * - 类定义处：提供初步的请求映射信息。相对于WEB应用的根目录
 * - 方法处：提供进一步的细分映射信息。相当于类定义处的URL。
 * - 举例 WEB根路径为 localhost:8080/SpringMVC/
 * - 类定义处路径为 /user
 * - 方法定义处路径为  /add
 * - 则该方法的访问路径为  localhost:8080/SpringMVC/user/add
 * - DispatcherServlet 截断请求后，就通过控制器上@RequestMapping提供的映射信息确定请求所对应的处理方法。
 * - 映射
 * - 请求参数
 * - 请求方法
 * - 请求头
 * <p>
 * 4、前端控制器的拦截：
 * - DefaultServlet是tomcat处理静态资源的
 * - 除过jsp和servlet，其他的都是静态资源；index.html也是静态资源；静态资源让tomcat来处理，tomcat就会在服务器下找到这个资源并返回。
 * - 所以DefaultServlet有效的情况下，index.html才有用
 * - tomcat有配置拦截规则，前端控制器也有，前端控制器相当于子类，重写了拦截规则！
 * - 相当于前端控制器的 / 把tomcat的DefaultServlet禁用掉了
 * - 此时静态资源就无效了。会来到前端控制器，看那个方法的RequestMapping是这个。没有那个方法的RequestMapping是index.html；没有！所有无法访问！找资源的方式都错了！！
 * - 为什么jsp又能访问？因为我们没有覆盖tomcat服务器中的JspServlet的配置
 * - 配置说明
 * - / 相当于把tomcat中的大web.xml的DefaultServlet重写了（静态资源拦截那个）
 * -  /* 直接是拦截所有请求。所以我们写  / ,写 / 也是为了迎合rest风格的url地址
 * - springmvc是先经过前端控制器的，看有没有配对的，没有就报错。
 */

/**
 * tomcat的web.xml中的文件
 * <!-- The mapping for the default servlet -->
 * <servlet-mapping>
 * <servlet-name>default</servlet-name>
 * <url-pattern>/</url-pattern>
 * </servlet-mapping>
 * 如果前端控制器的拦截配成了 *.jsp 就把这个覆盖掉了，jsp就无法访问了
 * <!-- The mappings for the JSP servlet -->
 * <servlet-mapping>
 * <servlet-name>jsp</servlet-name>
 * <url-pattern>*.jsp</url-pattern>
 * <url-pattern>*.jspx</url-pattern>
 * </servlet-mapping>
 */
@Controller
public class HelloController implements CorsConfigurationSource {

    @ResponseBody
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello MVC";
    }

    @ResponseBody
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @Override
    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
        return null;
    }
}
