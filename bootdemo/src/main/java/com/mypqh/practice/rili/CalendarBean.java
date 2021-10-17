package com.mypqh.practice.rili;

import java.util.Calendar;

public class CalendarBean {
    String[] day;
    int year;
    int month;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String[] getCalendar() {
        String[] a = new String[42];//6排*7天
        Calendar rili = Calendar.getInstance();
        rili.set(year, month - 1, 1);//每月一号
        int weekDay = rili.get(Calendar.DAY_OF_WEEK) - 1;//计算1号的星期
        //System.out.println(weekDay);
        int day = 0;//一个月天数设置
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            day = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11)
            day = 30;
        if (month == 2) {
            if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
                day = 29;//闰年29天
            else day = 28;//非闰年28天
        }
        for (int i = 0; i < weekDay; i++)//每月1号星期I之前加空
            a[i] = " ";
        for (int i = weekDay, n = 1; i < weekDay + day; i++) {
            a[i] = String.valueOf(n);
            n++;
        }
        for (int i = weekDay + day; i < a.length; i++)//每月最后加空
            a[i] = " ";
        return a;
    }
}
