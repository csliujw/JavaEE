package com.design.single;

public class Singleton {
    private static final Singleton singleton = new Singleton();

    private Singleton() {

    }

    /**
     * 会有线程安全问题
     */
    public static Singleton getInstance() {
        return singleton;
    }
}
