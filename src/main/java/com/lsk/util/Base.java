package com.lsk.util;

import java.util.Date;
import java.util.Random;

/**
 * @author LSKun
 */
public class Base {

    /**
     * 生产随机数的函数
     */
    private static Random random = new Random();

    /**
     * @param passDays 表示生成的最远的过去的天数
     * @return
     * 生成未来的一个时间
     */
    public static Date randomAfterDate(int passDays) {
        Date now = new Date();
        long mills = randomInteger(0, passDays) * 24L * 60L * 60L * 1000L;
        Date passDate = new Date(now.getTime() - mills);
        return passDate;
    }

    public static Date randomAfterDate() {
        Date now = new Date();
        long mills = 15 * 24L * 60L * 60L * 1000L;
        Date afterDate = new Date(now.getTime() + mills);
        return afterDate;
    }

    //创建一个随机整数
    public static Integer randomInteger(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
