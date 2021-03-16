package cn.baobaoxuxu.community.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "person")
public class YamlController {
    // Spring的表达式语言

    //    @Value("${name}")
    private String name;
    //    @Value("${person.name}")
    private String personName;

    @GetMapping("/name")
    public String getName() {
        return name;
    }

    @GetMapping("/personName")
    public String getPersonName() {
        return personName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
