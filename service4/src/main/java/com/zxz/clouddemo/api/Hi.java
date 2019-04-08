package com.zxz.clouddemo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hi {

    @RequestMapping("/hi")
    public String sayHi(){
        return "hi from service3!";
    }
}
