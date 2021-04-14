package se.oop;

/**
 * 父类只有有参构造函数
 */
public class SuperDemo1 {
}

class FatherSuperDemo1 {
    public FatherSuperDemo1(String msg) {
        System.out.println(msg);
    }
}

class SonSuperDemo1 extends FatherSuperDemo1 {
    public SonSuperDemo1() {
        // 加了super 才不会报错。
        super("hello");
    }
}