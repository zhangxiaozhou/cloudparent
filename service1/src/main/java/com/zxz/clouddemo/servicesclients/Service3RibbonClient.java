package com.zxz.clouddemo.servicesclients;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class Service3RibbonClient {

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    public String sayHi(){
        return restTemplate.getForObject("http://service3/hi", String.class);
    }
}
