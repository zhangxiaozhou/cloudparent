package com.zxz.clouddemo.api;

import com.zxz.clouddemo.feignclients.Service2Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

@RefreshScope
@RequestMapping("/hello")
@RestController
public class HelloController {

    @Resource
    private Service2Client service2Client;

    @RequestMapping("/world")
    public String world(Principal principal){


        return "hello world!" + service2Client.getHost();
    }
}
