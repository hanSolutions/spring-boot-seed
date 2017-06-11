package ca.hansolutions.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class HomeController {

    @GetMapping(value = "/login")
    public String getLoginPage(){

        System.out.println("Get request for get login page");
        return "login";
    }

    @PostMapping(value = "/home")
    public String getHomePage(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if(authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            return "adminHome";
        } else if(authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))){
            return "userHome";
        }

        String username = authentication.getName();
        System.out.printf("Get request for get login page, %s%n", username);
        return "home";
    }
}
