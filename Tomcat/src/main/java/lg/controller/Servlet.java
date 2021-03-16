package lg.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 访问这个Servlet的路径。 课本也采用的注解的配置方式， 未使用xml的配置方式。
// 趋势：推荐使用注解进行开发
public class Servlet extends HttpServlet {

    @Override
    // 单例模式 只执行一次 用于初始化资源  类比JDBC编程
    public void init() {
        System.out.println("init ...");
    }

//    // 查看service源码可知 service获取浏览器的请求形式 然后选择调用何种方法。
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String method = req.getMethod();
//        if ("GET".equals(method)) {
//            doGet(req, resp);
//        } else if ("doPost".equals(method)) {
//            doPost(req, resp);
//        } else if ("doPut".equals(method)) {
//            doPut(req, resp);
//        }
//    }

    // 只执行一次用于销毁资源
    @Override
    public void destroy() {
        System.out.println("destroy ...");
    }

    // 有service方法的话 不会调用 doPost和doGet方法
    // service 选择调用何种形式的Method
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Hello doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("123");
//        response.getWriter().write("Hello doGet");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello doPut");
    }
}
