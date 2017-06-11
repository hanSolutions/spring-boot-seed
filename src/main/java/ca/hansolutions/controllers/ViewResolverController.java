package ca.hansolutions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewResolverController {

    @GetMapping(value = "/view_thymeleaf")
    public String getThymeleaf(){

        return "view_thymeleaf";
    }

    @GetMapping(value = "/view_jsp")
    public String getJsp(){

        return "view_jsp";
    }
}
