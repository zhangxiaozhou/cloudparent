package com.zxz.clouddemo.servicesclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 演示feign调用下游服务时如何传递token
 */
@FeignClient("service2")
public interface Service2FeignClient {

    @RequestMapping("/consul/getHost")
    String getHost();
}
