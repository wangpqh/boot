package com.mypqh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getTodayFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static String getToday() {
        return formYearMonth(new Date());
    }

    public static long getOneDay(String day, String day2) {
        Date time1 = null;
        Date time2 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            time1 = simpleDateFormat.parse(day);
            time2 = simpleDateFormat.parse(day2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time1.getTime() - time2.getTime();
    }

    public static Date getThatDay(String day, long n) {
        Date time = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        try {
            time = simpleDateFormat.parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long all = 86400000 * n;
        return new Date(time.getTime() + all);
    }

    //格式化某天为【2020/12/13/Sunday】
    public static String formDay(Date date) {
        String[] timeArr = date.toString().split(" ");
        String week = null;
        switch (timeArr[0]) {
            case "Mon":
                week = "Monday";
                break;
            case "Tue":
                week = "Tuesday";
                break;
            case "Wed":
                week = "Wednesday";
                break;
            case "Thu":
                week = "Thursday";
                break;
            case "Fri":
                week = "Friday";
                break;
            case "Sat":
                week = "Saturday";
                break;
            case "Sun":
                week = "Sunday";
                break;
        }
        return new SimpleDateFormat("yyyy/MM/dd").format(date) + "/" + week;
    }

    //格式化某天为【2020/12/13】
    public static String formYearMonth(Date date) {
        String[] timeArr = date.toString().split(" ");
        return new SimpleDateFormat("yyyy/MM/dd").format(date);
    }

    //获取某月第一天
    public static Date genFirth(Date date) throws ParseException {
        String day = new SimpleDateFormat("yyyy/MM/dd").format(date);
        String result = day.substring(0, 8) + "01";
        SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
        return simple.parse(result);
    }

    public static String genFirthForm(Date date) throws ParseException {
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM/dd");
        return sim.format(genFirth(date));
    };
    // 获取今日周几
    public static String getWeekToday() {
        String res = formDay(new Date());
        String[] arr = res.split("/");
        return arr[3];
    }
    // 获取某月第一天周几
    public static String getFirthWeek(Date date) throws ParseException {
        Date day = genFirth(date);
        String[] arr = formDay(day).split("/");
        return arr[3];
    }
    // 获取今日周几
    public static String getWeek(Date date) {
        String res = formDay(date);
        String[] arr = res.split("/");
        return arr[3];
    }
/*
    public static void main(String[] args) throws ParseException {
        System.out.println(genFirthForm(new Date()));
        System.out.println(getFirthWeek(new Date()));
    }
*/

}

