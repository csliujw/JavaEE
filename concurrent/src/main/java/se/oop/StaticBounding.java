package se.oop;

public class StaticBounding {
    /**
     * 当通过b（静态类型Base）访问时，访问的是Base的变量和方法，<br>
     * 当通过c（静态类型Child）访问时，访问的是Child的变量和方法，<br>
     * 这称之为静态绑定：即访问绑定到变量的静态类型。<br>
     * 静态绑定在程序编译阶段即可决定，而动态绑定则要等到程序运行时。<br>
     * 实例变量、静态变量、静态方法、private方法，都是静态绑定的。<br>
     *
     * @param args
     */
    public static void main(String[] args) {
        StaticBounding.Child child = new StaticBounding.Child();
        StaticBounding.Base base = child;
        System.out.println(base.s);
        System.out.println(base.m);
        base.staticTest();
        System.out.println(child.s);
        System.out.println(child.m);
        child.staticTest();
    }

    static class Base {
        public static String s = "static_base";
        public String m = "base";

        public static void staticTest() {
            System.out.println("base static:" + s);
        }
    }

    static class Child extends Base {
        public static String s = "child_base";
        public String m = "child";

        public static void staticTest() {
            System.out.println("child static:" + s);
        }
    }
}
