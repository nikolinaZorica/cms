package com.nikolinaspringboot.cms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/*
Customizing a WhiteLabel Error Page
 */
@RestController
public class Home {

    @GetMapping
    public String home(){
        return "Application is work!!! " + new Date();
    }
}
