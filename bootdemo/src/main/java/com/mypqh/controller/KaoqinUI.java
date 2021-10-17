package com.mypqh.controller;

import com.alibaba.fastjson.JSONObject;
import com.mypqh.common.TableInfo;
import com.mypqh.service.KaoqinMonth;
import javafx.scene.control.Tab;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class KaoqinUI {
    @RequestMapping("/cal")
    public String calTable() {
        return "calculate";
    }

    @RequestMapping(value = "queryCal", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getData() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        Map<String, Object> dataMap1 = new HashMap<>();
        map.put("draw",1);
        map.put("total",200);
        map.put("recordsFiltered",200);
//        List<Map> list = KaoqinMonth.genneralMonth();
        List<Map> list = new ArrayList<>();
        TableInfo tb = new TableInfo();
        tb.setDate("6月19日");
        tb.setWeek("sun");
        tb.setIsWork(0);
        tb.setStatus(1);
        tb.setOther("no");

        TableInfo tb1 = new TableInfo();
        tb1.setDate("6月21日");
        tb.setWeek("mon");
        tb1.setIsWork(1);
        tb1.setStatus(1);
        tb1.setOther("normal");

        dataMap.put("Sun", tb);
        dataMap.put("Mon", tb1);
        dataMap.put("Tue", tb1);
        dataMap.put("Wen", tb1);
        dataMap.put("Thr", tb1);
        dataMap.put("Fri", tb1);
        dataMap.put("Sat", tb);

        dataMap1.put("Sun", tb);
        dataMap1.put("Mon", tb);
        dataMap1.put("Tue", tb1);
        dataMap1.put("Wen", tb1);
        dataMap1.put("Thr", tb1);
        dataMap1.put("Fri", tb1);
        dataMap1.put("Sat", tb);
        list.add(dataMap);
        list.add(dataMap1);
        map.put("data", list);
        return new JSONObject(map);
    }

}
