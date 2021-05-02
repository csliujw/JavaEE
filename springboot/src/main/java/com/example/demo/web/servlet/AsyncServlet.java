package com.example.demo.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

//  asyncSupported = true 支持异步，默认是false哦
@WebServlet(urlPatterns = {"/my/async"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(() -> {
            try {
                PrintWriter writer = resp.getWriter();
                for (int i = 0; i < 100; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    writer.write("Hello I am asyncContext");
                    writer.flush();
                }
                // 执行完毕后在告知 异步调用完成奥~
                asyncContext.complete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
