package com.man.concurrency.singleton;

public class SingletonExample2 {
    private SingletonExample2() {

    }

    private volatile static SingletonExample2 singletonExample2 = null;

    public static SingletonExample2 getSingletonExample2() {
        if (singletonExample2 == null) {
            synchronized (SingletonExample2.class) {
                if (singletonExample2 == null) {
                    singletonExample2 = new SingletonExample2();
                }
            }
        }
        return singletonExample2;
    }
}
