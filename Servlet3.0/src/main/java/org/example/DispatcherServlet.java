package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 前端控制器. 不处理具体的业务，只进行请求的转发。
 * 此处的前端控制器，只进行通用业务的处理，处理完毕后将请求转发，由其他Controller进行处理。
 */
@WebServlet(urlPatterns = {"/page/*"})
public class DispatcherServlet extends HttpServlet {
    private static final String PREFIX = "/Servlet/page/";
    // 假设一直都是登陆用户操作的。
    private static final boolean LOGIN = true;


    @Override
    public void init() throws ServletException {
        System.out.println("初始化资源");
    }

    @Override
    public void destroy() {
        System.out.println("销毁资源");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        String requestURI = req.getRequestURI(); // requestURI = /Servlet/page/2
        requestURI = requestURI.replace(PREFIX, "/");
        if (LOGIN) {
            req.getRequestDispatcher(requestURI).forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.html");
        }
    }
}
