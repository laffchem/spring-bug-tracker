package com.jlaffey.bugtrackersite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BugController {
    @RequestMapping("bugs")
    public String bugs(Model model) {
        model.addAttribute("title", "Bugs");
        return "bugs";
    }
}
