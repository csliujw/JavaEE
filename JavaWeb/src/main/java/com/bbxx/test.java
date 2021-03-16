package com.bbxx;

public class test {
    public static void main(String[] args) {
        String packageName = "com.bbxx.dao";
        String clazzName = "com.bbxx.dao.UserDao";
        char[] chars = packageName.toCharArray();
        char[] chars1 = clazzName.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println((int) chars[i]);
            System.out.println("-----------");
            System.out.println((int)chars[i] | (int)chars1[i]);
        }
    }
}
