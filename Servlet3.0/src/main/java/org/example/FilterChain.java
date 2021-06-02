package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

// 拦截所有请求。
@WebFilter(urlPatterns = {"/*"})
public class FilterChain implements Filter {
    private static PrintWriter log = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            String realPath = filterConfig.getServletContext().getRealPath("/aa.txt");
            log = new PrintWriter(realPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, javax.servlet.FilterChain chain) throws IOException, ServletException {
        log.println("======开始记录日志======");
        Enumeration<String> keys = request.getParameterNames();
        while (keys.hasMoreElements()) {
            log.println(keys.nextElement());
        }
        log.println("======结束记录日志======");
        log.flush();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
