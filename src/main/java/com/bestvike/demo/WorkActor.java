package com.bestvike.demo;

import com.bestvike.coroutine.Actor;

/**
 * Created by 许崇雷 on 2017/8/22.
 */
public final class WorkActor extends Actor {
    private final String name;
    private final int count;
    private int index;

    public WorkActor(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public boolean moveNext() {
        switch (this.state) {
            case 0:
                System.out.println(this.name + " started");
                this.state = 1;
            case 1:
                if (this.index < this.count) {
                    Utils.work();
//                    System.out.println(this.name + " work done " + this.index);
                    this.index++;
                    return true;
                }
                this.close();
                System.out.println(this.name + " ended");
                return false;
            default:
                return false;
        }
    }
}
