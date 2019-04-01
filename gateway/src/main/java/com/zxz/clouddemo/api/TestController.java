package com.zxz.clouddemo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String helloWorld(){

        return "hello world!";
    }
}
