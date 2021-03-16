package org.example.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class MyView implements View {
    @Override
    public String getContentType() {
        // 返回的数据类型
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("之前存的数据" + model);
        // 过滤器替我们设置好了编码格式
        response.setContentType("text/html");
        response.getWriter().write("精彩内容 马上出现！哈哈哈！");
    }
}
