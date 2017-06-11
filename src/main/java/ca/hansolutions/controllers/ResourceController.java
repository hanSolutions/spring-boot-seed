package ca.hansolutions.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/resources")
public class ResourceController {


    @GetMapping(value = "/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminResource(){

        return "This resource could only be visited by a admin";
    }


    @GetMapping(value = "/user")
    @PreAuthorize("hasRole('USER')")
    public String getUserResource(){

        return "This resource could only be visited by a user";
    }
}
