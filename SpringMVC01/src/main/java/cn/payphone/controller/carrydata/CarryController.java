package cn.payphone.controller.carrydata;

import cn.payphone.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 给页面携带数据
 */
@Controller
@RequestMapping("/carry")
public class CarryController {

    @RequestMapping("/map")
    public String Map(Map<String, Object> map) {
        map.put("name", "liujiawe");
        // class org.springframework.validation.support.BindingAwareModelMap
        System.out.println(map.getClass());
        return "carry";
    }

    @RequestMapping("/model")
    public String Model(Model model) {
        model.addAttribute("name", "liujiawei model");
        // class org.springframework.validation.support.BindingAwareModelMap
        System.out.println(model.getClass());
        return "carry";
    }

    @RequestMapping("/modelMap")
    public String ModelMap(ModelMap map) {
        map.addAttribute("name", "Model Map vale");
        // class org.springframework.validation.support.BindingAwareModelMap
        System.out.println(map.getClass());
        return "carry";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("model");
        modelAndView.addObject("model", "mymodel");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/get")
    public User get(@ModelAttribute("user") User user) {
        return user;
    }

    @ModelAttribute
    public void ModelAttribute(Model model) {
        User user = new User();
        user.setAddress("address");
        user.setAge(18);
        user.setName("ljw");
        model.addAttribute("user", user);
    }
}
