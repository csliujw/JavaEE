public class Demo {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        method(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    private static void method(int a, int b) {
        System.out.println("a=" + 100);
        System.out.println("b=" + 100);
        System.exit(0);
    }
}
