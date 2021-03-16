package org.example.configuration.ioc.assembly;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

@Configuration
@Import({ImportBeanDefinitionDemo.class})
public class ImportBeanDefinitionRegistrarConfiguration {

    @Bean("red")
    public Red red() {
        return new Red();
    }

}

class ImportBeanDefinitionDemo implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("red");
        if (red) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rain.class);
            registry.registerBeanDefinition("Rain", rootBeanDefinition);
        }
    }
}

class Red {

}

class Rain {

}