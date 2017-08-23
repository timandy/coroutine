package com.bestvike.demo;

/**
 * Created by 许崇雷 on 2017/8/22.
 */
public class WorkThread extends Thread {
    private final String name;
    private final int count;
    private int index;

    public WorkThread(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(this.name + " started");
        for (this.index = 0; this.index < this.count; this.index++) {
            Utils.work();
//            System.out.println(this.name + " work done " + this.index);
        }
        System.out.println(this.name + " ended");
    }
}
