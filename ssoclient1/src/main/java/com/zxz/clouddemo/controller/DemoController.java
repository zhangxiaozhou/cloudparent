package com.zxz.clouddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/demo")
@Controller
public class DemoController {

    @RequestMapping("/secretPage")
    public String secretPage(){

        return "secret_page";
    }
}
