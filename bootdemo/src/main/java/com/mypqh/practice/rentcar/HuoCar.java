package com.mypqh.practice.rentcar;

public class HuoCar extends Car {
    double weightHuo;

    public double getWeightHuo() {
        return weightHuo;
    }

    public void setWeightHuo(double weightHuo) {
        this.weightHuo = weightHuo;
    }

    public HuoCar(int num, String name, double rentMoney, double weightHuo) {
        super();
    }

    @Override
    public String toString() {
        return num + "\t" + name + "\t"
                + rentMoney + "\t\t" + load + "吨";
    }
}
