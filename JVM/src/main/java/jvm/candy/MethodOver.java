package jvm.candy;

import java.lang.reflect.Method;

class A {
    public Number m() {
        return 1;
    }
}

class B extends A {
    @Override
// 子类 m 方法的返回值是 Integer 是父类 m 方法返回值 Number 的子类
    public Integer m() {
        return 2;
    }
}

public class MethodOver {
    public static void main(String[] args) {
        for (Method m : B.class.getDeclaredMethods()) {
            System.out.println(m);
        }
    }
}
