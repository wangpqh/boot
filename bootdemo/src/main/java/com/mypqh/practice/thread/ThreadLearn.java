package com.mypqh.practice.thread;

import java.util.concurrent.*;

public class ThreadLearn {
    public static void main(String[] args) {

        WorkThread workThread = new WorkThread();

        Thread thread = new Thread(workThread);
        thread.start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(workThread);

/*
        Executors.newCachedThreadPool();//可缓存线程池
        Executors.newFixedThreadPool(5);//定长线程池，
        Executors.newSingleThreadExecutor();//一个单线程化的线程池
        Executors.newScheduledThreadPool(5);//时间间隔周期性执行一个任务。
*/

        BlockingDeque queue = null;

/**
 * int corePoolSize,      //核心线程池大小
 * int maximumPoolSize,    // 线程池最大值
 * long KeepAliveTime,     // 空闲线程保留时间
 * TimeUnit unit,          // 保留时间单位
 * BlockingQueue<Runnable> workQueue,  // 阻塞队列任务
 * RejectedExecutionHandler handler);  // 拒绝处理机制
 */
        ExecutorService executorService2 = new ThreadPoolExecutor(5, 8, 8, TimeUnit.SECONDS, queue);

    }
}
