package cn.sunline.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    public void saveUser(){
        System.out.println("这是controller的执行保存..");
    }
}