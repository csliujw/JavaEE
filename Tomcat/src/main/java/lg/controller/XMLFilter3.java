package lg.controller;

import javax.servlet.*;
import java.io.IOException;

public class XMLFilter3 implements Filter {
    public void destroy() {
        System.out.println("F3 destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter3");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init Filter3");
    }

}
