package com.man.concurrency.singleton;

public class SingletonExample1 {

    private SingletonExample1() {

    }

    private static SingletonExample1 singleton = null;

    public static SingletonExample1 getInstance() {
        if (singleton == null) {
            singleton = new SingletonExample1();
        }
        return singleton;
    }
}
