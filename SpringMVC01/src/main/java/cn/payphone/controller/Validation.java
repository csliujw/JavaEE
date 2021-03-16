package cn.payphone.controller;

import cn.payphone.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/validation")
public class Validation {

    @RequestMapping("/val")
    @ResponseBody
    public String validation(@Valid User user, BindingResult result) {
        boolean b = result.hasErrors();
        List<ObjectError> allErrors = result.getAllErrors();
        StringBuffer buffer = new StringBuffer();
        for (ObjectError err : allErrors) {
            buffer.append(err.getDefaultMessage());
        }
        return buffer.toString();
    }


    @RequestMapping("/error")
    public String error() {
        int a = 10 / 0;
        return "123";
    }
}
