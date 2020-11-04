package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020-08-24 19:35
 * @company 阿里巴巴
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "success";
    }
}
