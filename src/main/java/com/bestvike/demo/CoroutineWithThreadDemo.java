package com.bestvike.demo;

import com.bestvike.coroutine.ActorEngine;

/**
 * Created by 许崇雷 on 2017/8/23.
 */
public class CoroutineWithThreadDemo {

    public static void main(String[] args) {
        //按核心数创建协程引擎
        ActorEngine[] engines = new ActorEngine[CONSTS.CORE_COUNT];
        for (int i = 0; i < CONSTS.CORE_COUNT; i++)
            engines[i] = new ActorEngine();
        //添加任务
        for (int i = 0; i < CONSTS.THREAD_COUNT; i++) {
            engines[i % CONSTS.CORE_COUNT].add(new WorkActor("thread " + i % CONSTS.CORE_COUNT + " corout  worker" + i, CONSTS.REPEAT_COUNT));
        }
        //按核心数创建线程
        Thread[] threads = new Thread[CONSTS.CORE_COUNT];
        for (int i = 0; i < CONSTS.CORE_COUNT; i++)
            threads[i] = new Thread(engines[i]);
        //启动线程
        for (Thread thd : threads)
            thd.start();
        ThreadUtils.sleep(1000000000);
    }
}
