package com.bestvike.demo;

/**
 * Created by 许崇雷 on 2017/8/22.
 */
public class Utils {
    public static long work() {
        long sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE / 20; i++)
            sum += i;
        return sum;
    }
}
