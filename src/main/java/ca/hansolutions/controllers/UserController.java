package ca.hansolutions.controllers;

import ca.hansolutions.models.User;
import ca.hansolutions.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/user")
    public String user(Map<String, Object> map, Principal principal){

        map.put("username", principal.getName());
        map.put("principal", principal);
        return "view_user";
    }

    @ResponseBody
    @GetMapping(value = "/users/{username}")
    public User addUser(@PathVariable String username){

        return userService.getUser(username);
    }

    @ResponseBody
    @PostMapping(value = "/users")
    public User addUser(@RequestBody User user){

        return userService.addUser(user);
    }
}
