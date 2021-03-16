package org.example.assembly;

import org.example.configuration.ioc.assembly.FactoryBeanConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FactoryBeanConfiguration.class)
public class FactoryBeanTest {
    @Autowired
    ApplicationContext context;

    @Test
    public void test1() {
        Object factoryBeanDemo = context.getBean("factoryBeanDemo");
        System.out.println(factoryBeanDemo.getClass());
        // 加上&符号 获取的是工厂对象 而非getObject返回的Bean
        Object bean = context.getBean("&factoryBeanDemo");
        System.out.println(bean.getClass());
    }
}
