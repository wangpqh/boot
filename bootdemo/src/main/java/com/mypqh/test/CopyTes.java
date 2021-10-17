package com.mypqh.test;

import com.mypqh.common.Student;
import org.junit.Test;

import java.util.*;


public class CopyTes {
    @Test
   public void singleVariableSort2(){

        List<String> list = Arrays.asList("北京","上海","北京","广州","广州","上海","北京","上海");

        List<String> sortRule = Arrays.asList("北京","上海","广州");

        System.out.println("原始数据：");
        list.forEach(n ->{System.out.print(n+", ");});

        System.out.println("");
        System.out.println("排序规则：");
        sortRule.forEach(n ->{System.out.print(n+", ");});

        System.out.println("");
        System.out.println("正序排列：");
        Collections.sort(list, new Comparator<String>()
        {
            public int compare(String a1, String a2)
            {
                int io1 = sortRule.indexOf(a1);
                int io2 = sortRule.indexOf(a2);
                return io1 - io2;
            }
        });

        list.forEach(n ->{System.out.print(n+", ");});

        System.out.println("");
        System.out.println("倒序排列：");
        list.sort(new Comparator<String>() {
            public int compare(String a1, String a2) {
                int io1 = sortRule.indexOf(a1);
                int io2 = sortRule.indexOf(a2);
                return io2 - io1;
            }
        });

        list.forEach(n ->{System.out.print(n+", ");});
    }


    public void entitySort1(){

        //Student 的 list 集合
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三",90,180,"电气学院","北京"));
        students.add(new Student("李四",80,165,"计算机学院","上海"));
        students.add(new Student("王五",91,170,"财经学院","上海"));
        students.add(new Student("赵明",80,182,"计算机学院","北京"));
        students.add(new Student("钱海",75,181,"计算机学院","广州"));
        students.add(new Student("孙理",82,172,"财经学院","上海"));
        students.add(new Student("周伟",90,168,"电气学院","广州"));
        students.add(new Student("郑亮",80,178,"财经学院","广州"));

        System.out.println("原始数据：");
        students.forEach(s ->{
            System.out.println(s.getName()+" "+ s.getScore()+" "+s.getHeight()+" "+ s.getCollege()+""+s.getAddress());});

        System.out.println("按照分数升序排序：");
        students.sort(Comparator.comparing(Student::getScore));
        students.forEach(s ->{
            System.out.println(s.getName()+" "+ s.getScore()+" "+s.getHeight()+" "+ s.getCollege()+""+s.getAddress());});

        System.out.println("按照分数降序排序：");
        students.sort(Comparator.comparing(Student::getScore).reversed());
        students.forEach(s ->{
            System.out.println(s.getName()+" "+ s.getScore()+" "+s.getHeight()+" "+s.getCollege()+""+s.getAddress());});
    }
}
