package com.man.concurrency.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample2 {

    private static final Logger logger = LoggerFactory.getLogger(SynchronizedExample2.class);

    public void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                logger.info("test1 {} -{}",j,i);
            }
        }
    }

    public static synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            logger.info("test2 - {}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }
}
