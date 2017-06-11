package ca.hansolutions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Map;

@Controller
public class AdminController {

    @GetMapping(value = "/admin")
    public String admin(Map<String, Object> map, Principal principal){

        map.put("username", principal.getName());
        return "view_admin";
    }
}
