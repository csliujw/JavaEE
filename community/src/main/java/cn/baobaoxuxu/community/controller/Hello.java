package cn.baobaoxuxu.community.controller;

import cn.baobaoxuxu.community.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Hello {

    @Autowired
    private RoleService roleService;

    @GetMapping("/index")
    public String index(@RequestParam(name = "name") String name) {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "Hello Worldsdfsdfasdf";
    }
}
