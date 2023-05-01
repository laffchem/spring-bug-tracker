package com.jlaffey.bugtrackersite.controllers;

import com.jlaffey.bugtrackersite.dtos.BugDto;
import com.jlaffey.bugtrackersite.dtos.ProjectDto;
import com.jlaffey.bugtrackersite.services.BugService;
import com.jlaffey.bugtrackersite.services.OrganizationService;
import com.jlaffey.bugtrackersite.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

}
