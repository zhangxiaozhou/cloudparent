package com.zxz.clouddemo.api;

import com.zxz.clouddemo.clients.Service4FeignClient;
import com.zxz.clouddemo.clients.Service4RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Hi {

    @Resource
    private Service4RibbonClient service4RibbonClient;

    @Resource
    private Service4FeignClient service4FeignClient;

    @RequestMapping("/hi")
    public String sayHi(){
        return "hi from service3!" + service4FeignClient.hi() + service4RibbonClient.hi();
    }
}
