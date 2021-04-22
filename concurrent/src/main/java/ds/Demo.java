package ds;

import java.util.ArrayList;

// 寻找大于这个数的下一个回文数
public class Demo {
    // 232 242
    // 233 先改成回文数232 再对其他位进行修改
    static ArrayList<Integer> huiwen(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        while (number != 0) {
            int yushu = number % 10;
            number = number / 10;
            list.add(yushu);
        }
        list.forEach(System.out::println);
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> huiwen = huiwen(111);
        // 先改成回文数，再对中间位数进行修改
        //   0    1       2       3
        //  个位  百位    千位     万位
        if ((huiwen.size() & 1) == 0) {
            System.out.println("size is 偶数" + huiwen.size());
        } else {
            System.out.println("size is 奇数" + huiwen.size());
        }
    }
}
