package com.mypqh.common;

public class Employ {
    String id;
    String name;
    String department;
    String position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "工号='" + id + '\'' +
                ", 姓名='" + name + '\'' +
                ", 部门='" + department + '\'' +
                ", 职位='" + position + '\'' +
                '}';
    }
}
