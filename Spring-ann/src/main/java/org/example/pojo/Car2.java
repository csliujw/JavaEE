package org.example.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car2 implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("car2 destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("car2 init afterPropertiesSet");
    }
}
