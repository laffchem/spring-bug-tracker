package com.jlaffey.bugtrackersite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FragmentController {

    @RequestMapping("login")
    public String login(Model model) {
        model.addAttribute("title", "Login");
        return "fragments/login";
    }

    @RequestMapping("register")
    public String register(Model model) {
        model.addAttribute("title", "Register");
        return "fragments/register";
    }

}
