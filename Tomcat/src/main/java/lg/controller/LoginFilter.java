package lg.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/***
 * 在web.xml中，filter执行顺序跟<filter-mapping>的顺序有关，先声明的先执行
 * 使用注解配置的话，filter的执行顺序跟名称的字母顺序有关，例如AFilter会比BFilter先执行
 * 如果既有在web.xml中声明的Filter，也有通过注解配置的Filter，那么会优先执行web.xml中配置的Filter
 */
//@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"}, initParams = {
//        @WebInitParam(name = "username", value = "root"),
//        @WebInitParam(name = "password", value = "root")
//})
public class LoginFilter implements Filter {
    private ArrayList<String> address = new ArrayList();

    public void destroy() {
    }

    // 防止url非法访问 不能直接通过url访问
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("LLL");
        String localName = req.getLocalName();
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        StringBuffer requestURL = request.getRequestURL();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            // 统一资源定位符  http://localhost:8080/TomcatDemo/
            String requestURI = request.getRequestURI();
            if (canPass(requestURI)) {
                chain.doFilter(req, resp);
            } else {
                System.out.println("*********************");
                request.getRequestDispatcher("/index.html").forward(request, response);
            }
        } else {
            chain.doFilter(req, resp);
        }
    }

    // 能否通过 包含才能通过
    private boolean canPass(String adr) {
        for (String str : address) {
            if (adr.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public void init(FilterConfig config) throws ServletException {
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        address.add("login");
        address.add("index");
        address.add("demo");
        System.out.println("L Filter");
    }

}
