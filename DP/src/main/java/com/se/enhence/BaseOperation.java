package com.se.enhence;

public class BaseOperation {

    public void fn1() {
        /*
         * have, 2<sup>31</sup>-1.
         *@Native public static final int MAX_VALUE = 0x7fffffff;
         */
        long a = Integer.MAX_VALUE * 2;
        // -2 怎么算的？不知道。后面再补吧。
        System.out.println(a);
        a = Integer.MAX_VALUE * 2L;
        // 4294967294
        System.out.println(a);
    }

    public void fun2() {
        int i = 0;
        i = ++i;
        i = ++i;
        // i = 2
        System.out.println(i);
    }

    public void fun3() {
        // 放在变量后（a++）是先用原来的值进行其他操作，然后再对自己做修改
        int i = 0;
        i = i++;
        i = i++;
        // i = 0
        System.out.println(i);
    }

    public void fun4() {
        boolean a = true;
        int b = 0;
        boolean flag = a || b++ > 0;
        System.out.println(flag);
    }

    // 表达式值的数据类型只能是byte、short、int、char、枚举和String（Java 7以后）
    public void fun5(String str) {
        switch (str) {
            case "A":
            case "B":
            case "C":
                System.out.println("CCCC");
                break;
            default:
                System.out.println("default");
        }
    }

    // 可变长参数实际上只是数组
    public void fun6(int number, String... str) {
        System.out.println(number);
        for (String s : str) {
            System.out.println(s);
        }
    }

    // 为什么需要函数重载呢？一般是因为函数想表达的意义是一样的，但参数个数或类型不一样

    /**
     * 本节遗留了一些问题，比如：
     * ❑ 正整数相乘的结果居然出现了负数；
     * ❑ 非常基本的小数运算结果居然不精确；
     * ❑ 字符类型也可以进行算术运算和比较
     */
    static int a = 0;

    public void digui() {
        a++;
        System.out.println(a);
        digui();
    }

    public static void main(String[] args) {
        BaseOperation baseOperation = new BaseOperation();
        baseOperation.digui();
    }
}
