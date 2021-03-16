package org.example;


import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 支持异步处理 asyncSupported = true
        // 2. 开启异步模式
        // 不设置响应类型就无法异步
        resp.setContentType("text/html");
        AsyncContext asyncContext = req.startAsync(req, resp);
        asyncContext.start(() -> {
            try {
                PrintWriter writer = asyncContext.getResponse().getWriter();
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    writer.write("123");
                    writer.flush();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                asyncContext.complete();
            }
        });
    }
}
