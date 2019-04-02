package com.zxz.clouddemo.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RefreshScope
@RestController
@RequestMapping("/consul")
public class HelloController {

    @Value("${spring.cloud.consul.host}")
    private String consulHost;

    @RequestMapping("/getHost")
    public String world(Principal principal){

        return consulHost;
    }
}
