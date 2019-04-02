package com.zxz.clouddemo.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service2", fallback = Service2ClientFallback.class)
public interface Service2Client {

    @RequestMapping("/consul/getHost")
    String getHost();
}

@Component
class Service2ClientFallback implements Service2Client{

    @Override
    public String getHost() {
        return "unknow host!";
    }
}
