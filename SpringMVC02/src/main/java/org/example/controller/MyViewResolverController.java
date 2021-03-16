package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class MyViewResolverController {

    @RequestMapping("/handleplus")
    public String handleplus(Model mode) {
        ArrayList<String> vname = new ArrayList<String>();
        ArrayList<String> imgname = new ArrayList<String>();
        vname.add("童童");
        vname.add("菲菲");

        imgname.add("mengmeng");
        mode.addAttribute("video", vname);
        mode.addAttribute("imgs", imgname);
        return "meinv:/gaoqing";
    }
}
