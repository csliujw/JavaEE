package se.oop;

/**
 * 重载和重写
 * 当有多个重名函数的时候，在决定要调用哪个函数的过程中，首先是按照参数类型进行匹配的，换句话说，寻找在所有重载版本中最匹配的，然后才看变量的动态类型，进行动态绑定。<br>
 * 重写时，子类方法不能降低父类方法的可见性。不能降低是指，父类如果是public，则子类也必须是public，父类如果是protected，子类可以是protected，也可以是public，即子类可以升级父类方法的可见性但不能降低<br>
 */
public class OverrideAndOverload {

    public static void main(String[] args) {

    }

    class Base {
        public int sum(int a, int b) {
            System.out.println("base_int_int");
            return a + b;
        }
    }

    class Child extends OverrideAndOverload.Base {
        // 重载是指方法名称相同但参数签名不同
        // 重写是指子类重写与父类相同参数签名的方法
        // 这里是重写
        @Override
        public int sum(int a, int b) {
            System.out.println("child_int_int");
            return a + b;
        }

        public long sum(long a, long b) {
            System.out.println("child_long_long");
            return a + b;
        }
    }
}
