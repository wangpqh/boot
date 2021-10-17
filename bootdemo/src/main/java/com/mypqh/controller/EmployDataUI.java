package com.mypqh.controller;

import com.mypqh.common.Employ;
import com.mypqh.mapper.EmployMapper;
import com.mypqh.service.EmployService;
import com.mypqh.util.DateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployDataUI {

    @Autowired
    EmployService employService;

    @GetMapping(value = "/getOne")
    public String getEmploy(Model model) {
        Map<String, Object> result = new HashMap<String, Object>();

        Employ em = employService.getOne("001");//待传
        result.put("applyId","210811001");
        result.put("emId", em.getId());
        result.put("name", em.getName());
        result.put("position", em.getPosition());
        result.put("today", DateUtil.getToday());

        model.addAttribute("result", result);
        return "employone";
    }

    @GetMapping(value = "/getAll")
    public String getAll(Model model) {
        List<Employ> list = employService.getAllEmploy();
//        System.out.println(list);
        model.addAttribute("result",list);
        return "employ";
    }

/*    @RequestMapping(value = "/queryEm")
    public Map<String,Object> queryData(){
        Map<String,Object> map=new HashMap<>();
        map.put("draw",1);
        return map;
    }*/


}
