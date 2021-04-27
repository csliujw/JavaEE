package jvm.oos;

/**
 * 栈溢出
 */
public class OutOfStack {
    private static int count = 0;

    public static void main(String[] args) {
        testStackOverFlowError();
    }

    private static void testStackOverFlowError() {
        count++;
        System.out.println(count);
        testStackOverFlowError();
    }
}
