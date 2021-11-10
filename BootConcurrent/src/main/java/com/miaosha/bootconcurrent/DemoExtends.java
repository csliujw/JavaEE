package com.miaosha.bootconcurrent;

public class DemoExtends extends Fu {
    int a = 100;

    public void test1() {
        Fu de = new DemoExtends();
        System.out.println(de.a); // 10
    }

    public static void main(String[] args) {
        new DemoExtends().test1();
    }
}


class Fu {
    int a = 10;
}