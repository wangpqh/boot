package com.mypqh.controller;

import com.mypqh.common.Constant;
import com.mypqh.util.DateUtil;
import com.mypqh.util.FileUtil;
import com.mypqh.util.NameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AccountApplyUI {
    @RequestMapping("/apply")
    public String apply(Model model) {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("appId", 123);
        result.put("ip", "10.3.3.55");
        result.put("today", DateUtil.getToday());
        model.addAttribute("result", result);
        return "apply";
    }

    @PostMapping("/applyAccount")
    public String getAccount(@RequestParam("name") String name, Model model) {

        if (name.matches("[\u4e00-\u9fa5]")) {
            Map<String, Object> result = new HashMap<>();
            String[] nameA = NameUtil.generateName().toString().split(",");
            String[] nameB = NameUtil.generateName(name).toString().split(",");
            result.put("flag", Constant.ZERO);
            Map mapA = NameUtil.getNameMap(nameA, Constant.EIGHT);
            Map mapB = NameUtil.getNameMap(nameB, Constant.NINE);
            if (mapA.isEmpty() && mapB.isEmpty()) {
                result.put("getNameA", "get Name failed");
                result.put("getNameB", "get Name failed");
            } else {
                result.put("getNameA", mapA);
                result.put("getNameB", mapB);
            }
            result.put("getNameFull", NameUtil.getRandomFullName(24));
            model.addAttribute("result", result);
            return "welcome";
        }

        name = NameUtil.generateCountName(name);
        StringBuffer password = NameUtil.getPassword();
        Map<String, Object> result = new HashMap<>();
        result.put("flag", Constant.ONE);
        result.put("name", name);
        result.put("password", password);
        model.addAttribute("result", result);
        return "welcome";
    }

    @RequestMapping("/article")
    public String read(Model model) {
        Map<String, Object> content = new HashMap<String, Object>();
        content.put("article",NameUtil.generateArticle());
        content.put("flag",1);
        model.addAttribute("content", content);
        return "novelist";
    }
}
