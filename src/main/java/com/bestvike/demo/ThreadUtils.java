package com.bestvike.demo;

/**
 * Created by 许崇雷 on 2017/8/22.
 */
public class ThreadUtils {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
