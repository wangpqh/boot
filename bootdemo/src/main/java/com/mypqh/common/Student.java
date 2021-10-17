package com.mypqh.common;

public class Student {
    String name;
    int score;
    int height;
    String college;
    String address;

    public Student(String name, int score, int height, String college, String address) {
        this.name = name;
        this.score = score;
        this.height = height;
        this.college = college;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
