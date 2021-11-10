package cn.payphone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/rest", produces = "text/html;charset=utf-8")
public class RestDemo {

    @GetMapping("/")
    public String index() {
        return "rest";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable String id) {
        return id + " delete";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put() {
        return "put success";
    }
}
