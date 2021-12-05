package com.mypqh.controller;

import com.mypqh.common.Result;
import com.mypqh.common.UserInfo;
import com.mypqh.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Api("index 首页接口")
public class IndexUI {

    @RequestMapping("/index")
    @ApiOperation(value = "首页访问", notes = "首页", httpMethod = "GET")
    public String index() {
        return "index";
    }

    @RequestMapping("/data")
    @ApiOperation(value = "datatable实例访问", notes = "datatable.js", httpMethod = "POST")
    public String dataTable() {
        return "datatables";
    }

    @PostMapping("api/login")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "登录", notes = "用户名+密码登录", httpMethod = "POST")
    public Result login(@RequestBody UserInfo user) {

        Result result = new Result();

        String name = user.getUsername();
        String pwd = user.getPassword();

        Map userId = new HashMap();
        userId.put("username", name);
        String access_token = JwtUtil.createJwt(userId);

        System.out.println(name + "/" + pwd);
        if (name.equals("wang") && pwd.equals("123")) {
            result.setResultCode("200");
            result.setResultDetail("success");
            result.setResultData(access_token);
        } else {
            result.setResultCode("500");
            result.setResultDetail("fail");
        }
        return result;
    }
}
