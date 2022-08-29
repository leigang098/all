package cn.itcast.user.utils;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AsyncWorker {

	private AsyncWorker() {

	}

	// 30s开启时间
	private static final int KEEP_ALIVE_TIME = 30;

	private static final ThreadPoolExecutor worker = new ThreadPoolExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME,
			TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new RejectedExecutionHandler() {
				@Override
				public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
					throw new RejectedExecutionException(String.format(
							"Thread pool is EXHAUSTED! Thread Name: %s, Pool Size: %d (active: %d, core: %d, max: %d, largest: %d), "
									+ "Queue: %d, Task: %d (completed: %d), Executor status:(isShutdown:%s, isTerminated:%s, isTerminating:%s)",
							Thread.currentThread().getName(), e.getPoolSize(), e.getActiveCount(), e.getCorePoolSize(),
							e.getMaximumPoolSize(), e.getLargestPoolSize(), e.getQueue().size(), e.getTaskCount(),
							e.getCompletedTaskCount(), e.isShutdown(), e.isTerminated(), e.isTerminating()));
				}
			});

	public static void execute(final Runnable runnable) {
		worker.execute(runnable);
	}

	public static void shutdown() {
		worker.shutdown();
	}
}
