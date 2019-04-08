package com.zxz.clouddemo.servicesclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service3")
public interface Service3FeignClient {

    @RequestMapping("/hi")
    public String hi();
}
