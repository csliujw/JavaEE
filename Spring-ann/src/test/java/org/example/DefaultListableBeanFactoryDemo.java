package org.example;

import org.example.pojo.Person;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class DefaultListableBeanFactoryDemo {

    @Test
    public void xml() {
        /**
         * XmlBeanFactory 类
         */
        ClassPathResource resource = new ClassPathResource("bean.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        Object person = factory.getBean("pojo");
        System.out.println(person);
    }

    @Test
    public void xmlApplication() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Person bean = context.getBean(Person.class);
        System.out.println(bean);
    }


}
