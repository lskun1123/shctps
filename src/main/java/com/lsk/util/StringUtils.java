package com.lsk.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 字符串工具类
 */
public class StringUtils {

    public static void main(String[] args) {
        System.out.println(new Date());
    }

    /**
     * 非空判断
     * @param str
     * @return
     */
    public static boolean isNotNull(String str){
        return str != null && !"".equals(str);
    }

    /**
     * 产生一个UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }

    /**
     * 获取当前时间
     * 日期格式为  yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getCurrentTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }


    private static String str = "abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ0123456789";

    /**
     * 获取随机的字符串
     * @param len 字符串的长度
     * @return 随机得到的字符串
     */
    public static String getRandomString(int len){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i < len;i++){
            int r = (int)(Math.random()*str.length());
            char c = str.charAt(r);
            sb.append(c);
        }
        return sb.toString();
    }

}
