package com.bestvike.demo;

import com.bestvike.coroutine.ActorEngine;

/**
 * Created by 许崇雷 on 2017/8/22.
 */
public class CoroutineDemo {

    public static void main(String[] args) {
        ActorEngine engine = new ActorEngine();
        for (int i = 0; i < CONSTS.THREAD_COUNT; i++) {
            engine.add(new WorkActor("corout worker" + i, CONSTS.REPEAT_COUNT));
        }
        engine.run();
    }
}
