package com.zxz.clouddemo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service4")
public interface Service4FeignClient {

    @RequestMapping("/hi")
    public String hi();
}
