package lg;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

// 容器启动的时候会将@HandlesTypes指定的这个类型下面的子类（实现类）传递过来
// 写一个感兴趣的类型.
@HandlesTypes(value = {Hello.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    /**
     * @param c   感兴趣的类型的所有子类型
     * @param ctx 代表当前web应用的ServletContext：一个web应用一个ServletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("感兴趣的类型");
        for (Class<?> clazz : c) {
            System.out.println(clazz);
        }
        // 注册 Servlet 組件
        ServletRegistration.Dynamic userServlet = ctx.addServlet("userServlet", UserServlet.class);
        // 配置Servlet的映射信息
        userServlet.addMapping("/userServlet");

        ServletRegistration.Dynamic demo = ctx.addServlet("demo", Demos.class);
        demo.addMapping("/demo");
        // 注冊监听器
        ctx.addListener("lg.UserListener");
        FilterRegistration.Dynamic userFilter = ctx.addFilter("userFilter", UserFilter.class);
        // userFilter.addMappingForServletNames(); // 专门拦截xxx Servlet
        userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*"); // 按路径拦截
    }
}

interface Hello {
}

class Demo implements Hello {
    public Demo() {
        System.out.println("Demo");
    }
}

class Demos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("!@#");
    }
}


