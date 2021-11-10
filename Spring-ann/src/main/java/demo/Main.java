package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ObjConfiguration.class);
        Person bean = context.getBean(Person.class);
        Person bean2 = context.getBean(Person.class);
        System.out.println(bean == bean2); // 默认单例模式
        System.out.println(bean);

        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("demo.xml");
        Person bean1 = context1.getBean(Person.class);
        System.out.println(bean1);
    }
}
