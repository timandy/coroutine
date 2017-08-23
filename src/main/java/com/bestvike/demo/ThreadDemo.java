package com.bestvike.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 许崇雷 on 2017/8/23.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        List<Thread> lst = new ArrayList<>(CONSTS.THREAD_COUNT);
        for (int i = 0; i < CONSTS.THREAD_COUNT; i++) {
            lst.add(new WorkThread("thread worker" + i, CONSTS.REPEAT_COUNT));
        }
        for (Thread thd : lst)
            thd.start();
        ThreadUtils.sleep(1000000000);
    }
}
