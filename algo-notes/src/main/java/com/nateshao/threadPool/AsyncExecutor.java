package com.nateshao.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncExecutor {
    private static ExecutorService executor = Executors.newCachedThreadPool();
}
