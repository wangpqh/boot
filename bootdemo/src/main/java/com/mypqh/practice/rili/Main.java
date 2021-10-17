package com.mypqh.practice.rili;

import java.util.Scanner;

/**
 * @author wtt
 * 功能：输入年份，打印当年的12个月的日历表
 * 时间：2017.11.12
 */
public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //输出日历
        CalendarBean c = new CalendarBean();
        while (true) {
            System.out.println("请输入年份");
            Scanner input = new Scanner(System.in);
            c.setYear(input.nextInt());
            int[] st = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
            System.out.println("----------" + c.getYear() + "年日历-----------");
            char[] str = "日一二三四五六".toCharArray();
            for (char b : str) {
                System.out.printf("%4c", b);
            }
            System.out.println();
            for (int d : st) {
                c.setMonth(d);
                System.out.print(d + "月");
                String[] a = c.getCalendar();//调用CalendarBean中的方法
                for (int i = 0; i < a.length; i++) {//一行七个数据打印
                    if (i % 7 == 0)
                        System.out.println(" ");
                    System.out.printf("%4s", a[i]);
                }
                System.out.println();
            }
            System.out.println("-------------end-------------");
        }
    }

}
