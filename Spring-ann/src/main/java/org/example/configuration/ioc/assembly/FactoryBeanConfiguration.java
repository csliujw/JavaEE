package org.example.configuration.ioc.assembly;

import org.example.pojo.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanConfiguration {
    @Bean
    public FactoryBeanDemo factoryBeanDemo() {
        return new FactoryBeanDemo();
    }
}

class FactoryBeanDemo implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    /**
     * @return true 单实例 容器中只保存一份
     * false 多实例 每次调用创建新对象
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
