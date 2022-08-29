package cn.itcast.user.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ZXM
 */
public class LableThreadPoolExcutor {

    private volatile static ThreadPoolExecutor threadPoolExecutor = null;

    private final static LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(1024);
    private final static int corePoolSize = 10;
    private final static long keepAliveTime = 5;
    private final static TimeUnit timeUnit = TimeUnit.SECONDS;
    private final static int maximumPoolSize = 15;
    private final static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Lable-thread-%d").build();

    private LableThreadPoolExcutor(){}

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        if(null==threadPoolExecutor){
            synchronized (LableThreadPoolExcutor.class){
                if(null==threadPoolExecutor){
                    threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, workQueue, threadFactory, new ThreadPoolExecutor.AbortPolicy());
                    System.out.println("线程池初始化成功");
                }
            }
        }
        return threadPoolExecutor;
    }
}
