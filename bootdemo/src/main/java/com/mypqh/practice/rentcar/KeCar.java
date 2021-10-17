package com.mypqh.practice.rentcar;

public class KeCar extends Car {

    int keNum;

    public int getKeNum() {
        return keNum;
    }

    public void setKeNum(int keNum) {
        this.keNum = keNum;
    }

    public KeCar() {

    }

    public KeCar(int num, String name, double rentMoney, int load) {
        super(num, name, rentMoney, load);
        // TODO Auto-generated constructor stub
    }


    @Override
    public String toString() {
        return num + "\t" + name + "\t"
                + rentMoney + "\t\t" + load + "人";
    }

}
