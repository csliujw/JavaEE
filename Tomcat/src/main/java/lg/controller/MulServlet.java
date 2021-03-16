package lg.controller;


import lg.pojo.User;
import lg.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo")
public class MulServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    // 这样的话，如何区分请求？
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String method = request.getParameter("method");
        // 不能用枚举，情况太多，枚举会复杂化问题。
        if ("login".equals(method)) {
            login(request, response);
        } else if ("logout".equals(method)) {
            logout(request, response);
        } else {
            response.getWriter().write("no this function");
        }
    }


    // 方法内部限定 请求方式
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!method(request, "POST")) {
            response.getWriter().write("Method ERROR");
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = userService.login(username, password);
            // 用户信息存入session
            if (user == null) {
                request.getRequestDispatcher("/index.html").forward(request, response);
            } else {
                request.getSession().setAttribute("user", user);
                response.getWriter().write("Welcome to here : " + user.getUsername());
            }
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
    }

    // 判断请求是否合法
    private boolean method(HttpServletRequest request, String methodType) {
        String method = request.getMethod();
        if (method.equals(methodType)) {
            return true;
        }
        return false;
    }

}
