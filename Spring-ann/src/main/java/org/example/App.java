package org.example;

import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        HashMap<Object, Object> map = new HashMap<>();
        map.put("1", "123");
        map.put("1", "123");
        map.put("1", "123");
        System.out.println(map.size());
        System.out.println("Hello World!");

    }
}
