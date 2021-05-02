package com.example.demo.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//  asyncSupported = true 支持异步，默认是false哦
@WebServlet(urlPatterns = {"/my/async"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(() -> {
            try {
                resp.getWriter().write("Hello I am asyncContext");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        // 触发完成
        asyncContext.complete();
    }
}
