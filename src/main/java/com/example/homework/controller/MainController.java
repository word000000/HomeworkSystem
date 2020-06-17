package com.example.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:GQM
 * @Date:created in 1:30 2020/6/1
 * @Description:
 * @Modifyed_By:
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("main")
    public String a() {
        return "index";
    }
}