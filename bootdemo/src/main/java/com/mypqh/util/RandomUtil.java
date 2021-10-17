package com.mypqh.util;

import com.mypqh.common.Constant;

import java.util.Random;

public class RandomUtil {
    public static int getRan() {
        return (int) (Constant.ONE + Math.random() * Constant.TEN);
    }

    //随机获取n以内的数
    public static int getRandom(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    //随机获取数组中的几位组成字符串
    public static String getRandomStr(char[] CHARS, int bit) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = Constant.ZERO; i < bit; i++) {
            int num = r.nextInt(CHARS.length);
            sb.append(CHARS[num]);
        }
        return sb.toString();
    }
}

