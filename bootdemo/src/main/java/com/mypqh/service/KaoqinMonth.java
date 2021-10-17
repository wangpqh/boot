package com.mypqh.service;

import com.mypqh.common.TableInfo;
import com.mypqh.practice.rili.CalendarBean;
import com.mypqh.util.DateUtil;

import java.text.ParseException;
import java.util.*;

public class KaoqinMonth {
    public static List<Map> genneralMonth() {

        Calendar cal = Calendar.getInstance();
        String year = String.valueOf(cal.get(Calendar.YEAR));
        String month = String.valueOf(cal.get(Calendar.MONTH));
        TableInfo tb = new TableInfo();
        try {
            String date = DateUtil.genFirthForm(cal.getTime()).split("-")[1];
            String week = DateUtil.getFirthWeek(cal.getTime());
            tb.setDate(date);
            tb.setWeek(week);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Map> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();

        tb.setIsWork(0);
        tb.setStatus(1);
        tb.setOther("no");


        switch (tb.getWeek()) {
            case "sun":
                map.put("Sun", tb);
            case "mon":
                map.put("Mon", tb);
            case "tue":
                map.put("Tue", tb);
            case "wen":
                map.put("Wen", tb);
            case "thr":
                map.put("Thr", tb);
            case "fri":
                map.put("Fri", tb);
            case "sat":
                map.put("Sat", tb);
        }

        list.add(map);
/*        CalendarBean c = new CalendarBean();
        String[] a = c.getCalendar();//调用CalendarBean中的方法
        for (int i = 0; i < a.length; i++) {//一行七个数据打印
            if (i % 7 == 0) {
                map.put("", " ");
            }
            map.put("", a[i]);
        }*/

        //[sunMap,monMap,tuemap,wenmap,thrmap,frimap,satmap]
        //sunMap <sun,tbinfo>

        return list;
    }


}
