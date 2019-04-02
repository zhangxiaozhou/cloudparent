package com.zxz.clouddemo.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service2")
public interface Service2Client {

    @RequestMapping("/consul/getHost")
    String getHost();
}
