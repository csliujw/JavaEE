package se.oop;

/**
 * 父类只有有参构造函数
 * 第一次输出为0，第二次输出为123。第一行为什么是0呢？<br>
 * 第一次输出是在new过程中输出的，在new过程中，首先是初始化父类，<br>
 * 父类构造方法调用test()方法，test()方法被子类重写了，就会调用子类的test()方法，<br>
 * 子类方法访问子类实例变量a，而这个时候子类的实例变量的赋值语句和构造方法还没有执行，<br>
 * 所以输出的是其默认值0。<br>
 */
public class SuperDemo2 {
    public static void main(String[] args) {
        Child child = new Child(); // 输出0
        child.test(); // 输出 123
    }
}

class Base {
    public Base(String msg) {
        System.out.println(msg);
        test();
    }

    public void test() {
        System.out.println("Base test");
    }
}

class Child extends Base {
    private int a = 123;

    public Child() {
        // 加了super 才不会报错。
        super("hello");
    }

    public void test() {
        System.out.println(a);
    }
}