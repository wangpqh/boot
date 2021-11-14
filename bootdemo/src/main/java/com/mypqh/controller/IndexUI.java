package com.mypqh.controller;

import com.mypqh.common.Result;
import com.mypqh.common.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexUI {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/data")
    public String dataTable() {
        return "datatables";
    }

    @PostMapping("api/login")
    @CrossOrigin
    @ResponseBody
    public Result login(@RequestBody UserInfo user) {
        String name=user.getUsername();
        String pwd=user.getPassword();
        String resultCode;
        String detail;
        System.out.println(name+"/"+pwd);
        if (name.equals("wang") && pwd.equals("123")) {
            resultCode = "200";
            detail = "success";
        } else {
            resultCode = "500";
            detail = "fail";
        }
        return new Result(resultCode, detail);
    }
}
