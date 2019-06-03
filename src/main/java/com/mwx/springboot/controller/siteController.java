package com.mwx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class siteController {


    @GetMapping(value = {"","/"})
    public String index(){
        return "groupPurchase";
    }


    @GetMapping("/groupPurchase")
    public String groupPurchase(){
        return "groupPurchase";
    }







}
