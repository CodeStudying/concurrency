package com.man.concurrency.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample1 {

    private static final Logger logger = LoggerFactory.getLogger(SynchronizedExample1.class);

    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                logger.info("test1 {} -{}",j,i);
            }
        }
    }

    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            logger.info("test2 - {}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }
}
