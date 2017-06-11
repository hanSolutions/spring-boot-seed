package ca.hansolutions.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(value = "/status")
    public String getServerStatus(){

        return "The server is up and running";
    }


}
