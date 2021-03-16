package org.example;

import org.springframework.core.convert.converter.Converter;

public class MyStringToPersonConverter implements Converter<String, Person> {
    @Override
    public Person convert(String source) {
        Person person = new Person();
        System.out.println("提交过来的字符串是" + source);
        if (source.contains("-")) {
            String[] split = source.split("-");
            person.setName(split[0]);
            person.setAge(Integer.valueOf(split[1]));
        }
        return person;
    }

}
