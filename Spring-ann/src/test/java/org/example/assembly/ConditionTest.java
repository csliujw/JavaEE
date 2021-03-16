package org.example.assembly;

import org.example.configuration.ioc.assembly.ConditionConfiguration;
import org.example.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConditionConfiguration.class)
public class ConditionTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void test1() {
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        Stream.of(beanNamesForType).forEach(System.out::println);
    }

    @Test
    public void test2() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
