package com.zxz.clouddemo.api;

import com.zxz.clouddemo.servicesclients.Service2FeignClient;
import com.zxz.clouddemo.servicesclients.Service2RibbonClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RefreshScope
@RequestMapping("/hello")
@RestController
public class HelloController {

    @Resource
    private Service2RibbonClient service2RibbonClient;

    @Resource
    private Service2FeignClient service2FeignClient;

    @RequestMapping("/world")
    public String world(Principal principal){

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();

        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());

        return "hello world!" + service2RibbonClient.getHost();

        //return service2FeignClient.getHost();
    }
}
