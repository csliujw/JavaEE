package com.ioc;

import org.example.pojo.Person;
import org.springframework.beans.annotation.AnnotationBeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class DefaultListableBeanFactoryDemo {

    public static void xml() {
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

    public static void xmlApplication() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Person bean = context.getBean("person", Person.class);
        System.out.println(bean);
    }



    public static void main(String[] args) {
        xmlApplication();
    }

}
