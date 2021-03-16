package org.example;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ConvertController {

    @RequestMapping("/conver")
    @ResponseBody
    public Person person(Person person) {
        System.out.println(person);
        return person;
    }

    @RequestMapping("/date")
    @ResponseBody
    // birth=2019-11-11才行
    public String date(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birth) {
        return birth.toString();
    }

    @RequestMapping("/number")
    @ResponseBody
    // birth=2019-11-11才行
    public String number(@NumberFormat(pattern = "#,###,###.#") Double number) {
        return number.toString();
    }

    @ExceptionHandler(value = {NullPointerException.class, ArithmeticException.class})
    public void f() {

    }
}
