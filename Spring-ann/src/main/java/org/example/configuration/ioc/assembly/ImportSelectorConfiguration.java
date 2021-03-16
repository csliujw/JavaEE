package org.example.configuration.ioc.assembly;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Set;

@Configuration
@Import({ImportSelectorDemo.class})
public class ImportSelectorConfiguration {
    @Bean
    public Object getObj() {
        return new Object();
    }
}

class ImportSelectorDemo implements ImportSelector {

    /**
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息，
     *                               简而言之，可以获取到Import注解和其他注解的信息
     * @return 要导入到组件的全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        ArrayList<String> list = new ArrayList<String>();
        String[] strings = new String[annotationTypes.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i);
        }
        return strings;
    }

}

class SelectorClassDemo {

}
