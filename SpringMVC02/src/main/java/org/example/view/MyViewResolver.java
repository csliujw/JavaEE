package org.example.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class MyViewResolver implements ViewResolver, Ordered {

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        // 根据视图名返回视图对象
        if (viewName.startsWith("meinv")) {
            return new MyView();
        } else {
            // 不能处理返回null即可
            return null;
        }
    }

    @Override
    public int getOrder() {
        // 解析器的获取优先级。数字越小优先级越高
        return 0;
    }
}
