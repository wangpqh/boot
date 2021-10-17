package com.mypqh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexUI {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/data")
    public String dataTable(){
        return "datatables";
    }
}
