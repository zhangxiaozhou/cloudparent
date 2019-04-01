package com.zxz.clouddemo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @RequestMapping("/world")
    public String world(Principal principal){


        return "hello world!" + principal.toString();
    }
}
