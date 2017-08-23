package com.bestvike.coroutine;

/**
 * Created by 许崇雷 on 2017/8/22.
 */
public class ActorEngine extends CycleList<Actor> implements Runnable {
    public void run() {
        System.out.println("ActorEngine started on thread:" + Thread.currentThread().getId());
        while (this.moveNext()) {
            CycleEntry<Actor> entry = this.current();
            if (!entry.item.moveNext())
                this.remove();
        }
        System.out.println("ActorEngine ended on thread:" + Thread.currentThread().getId());
    }
}
