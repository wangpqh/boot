package com.mypqh.practice.rentcar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i = 0;
        double sum = 0.0;
        Car[] cars = new Car[10];
        KeCar ke=new KeCar();

        cars[0] = new KeCar(1, "大众", 100, 5);
        cars[1] = new KeCar(2, "大众", 200, 7);
        cars[2] = new KeCar(3, "马自达", 200, 5);
        cars[3] = new HuoCar(4, "解放", 200, 6);
        cars[4] = new HuoCar(5, "红旗", 300, 8);

        System.out.println("---欢迎来到苹果租车系统！---");
        System.out.println("请问您是否要租车？");
        do {
            System.out.println("请选择1.是  2.不是");
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            //如果收到1.打印car列表，否则退出系统
            if (a == 1) {
                System.out.println("我们提供的车型如下：");

                System.out.println("序号   " + "\t" + "汽车名称   " + "\t" + "租金(元/天)" + "\t" + "容量   ");
                for (i = 0; i < cars.length; i++) {
                    System.out.println(cars[i]);
                }
                //	do{
                System.out.println("请选择您想租车的序号:");
                int b = input.nextInt();
                //数字输入审核
                while (b <= 0) {
                    System.out.println("您输入的序号错误！请重新输入...");
                    System.out.println("请选择您想租车的序号:");
                    b = input.nextInt();
                }
                //选择车型与租车量，租车天数
                System.out.println("请输入您想租车天数:");
                int c = input.nextInt();
                while (c <= 0) {
                    System.out.println("您输入的天数不符合！请重新输入...");
                    System.out.println("请输入您想租车天数:");
                    c = input.nextInt();
                }
                //计算总费用，
                for (i = 0; i < cars.length; i++) {
                    if (b == cars[i].num) {
                        sum = c * cars[i].rentMoney;
                    }
                }

                System.out.println("您的租车花费为：" + sum);

                //}while(true);
            } else if (a == 2) {
                System.out.println("---欢迎下次光临！---");
                System.exit(0);
            }
            System.out.println("您是否还要租车？");
        } while (true);
    }
	/*public static  void CarInfo(){//显示车表单
		Car [] cars = new Car[5];
		cars[0]=new KeCar(1,"大众" , 100, 5);
		cars[1]=new KeCar(2,"大众" , 200, 7);
		cars[2]=new KeCar(3,"马自达" , 200, 5);
		cars[3]=new HuoCar(4, "解放", 200, 6);
		cars[4]=new HuoCar(5, "红旗", 300, 8);
		System.out.println("序号   "+"\t"+"汽车名称   "+"\t"+"租金(元/天)"+"\t"+"容量   ");		
		for(int i=0;i<cars.length;i++){
			System.out.println(cars[i]);
		}	
	}
	public static  double Calculate(int x,int y) {//计算租金
		int i=0;
		double sum=0.0;
		//Calculate cars = new Calculate();	
		CarInfo();
		while(x==cars[i].num)
		{
			sum=y*cars[i].rentMoney;
			i++;
		}
		return sum;
	}*/

}
