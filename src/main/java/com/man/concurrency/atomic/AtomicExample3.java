package com.man.concurrency.atomic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicExample3 {
    private static final Logger logger = LoggerFactory.getLogger(AtomicExample3.class);

    private static AtomicIntegerFieldUpdater<AtomicExample3> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample3.class, "count");

    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample3 example3 = new AtomicExample3();

        if (updater.compareAndSet(example3, 100, 120)) {
            logger.info("update success 1, {}", example3.count);
        }

        if (updater.compareAndSet(example3, 100, 120)) {
            logger.info("update success 2, {}", example3.count);
        } else {
            logger.info("update failed, {}", example3.count);
        }

    }


}
