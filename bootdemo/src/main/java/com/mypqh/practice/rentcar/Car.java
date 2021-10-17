package com.mypqh.practice.rentcar;

public class Car {
    int num;//号码
    String name;//牌子名
    double rentMoney;//租金
    double load;//负载

    public Car() {
    }

    public void Car() {

    }

    public Car(int num, String name, double rentMoney, double load) {
        this.num = num;
        this.name = name;
        this.rentMoney = rentMoney;
        this.load = load;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRentMoney() {
        return rentMoney;
    }

    public void setRentMoney(double rentMoney) {
        this.rentMoney = rentMoney;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }
}