package ds;

import java.util.*;

public class Demo2 {
    // 处理数组,如果数据的输入是无序的，则要获得对于数据的index。
    // 记录它的序列号
    static int[] deal(int[] array) {
        int[] map = new int[65535 + 2];
        for (int i = 0; i < array.length; i++) {
            map[array[i]] = i + 1;
        }
        return map;
    }

    static void test1() {
        Scanner scanner = new Scanner(System.in);
        // 用户数目,广告数目
        int n = 3, k = 5;
        // 发广告的用户数组
        int[] user = new int[n];
        // 模拟键盘录入数据
        int[] array = {9, 6, 3};
        for (int j = 0; j < array.length; j++) {
            user[j] = array[j];
        }
        ArrayList<Integer> retVal = new ArrayList<>();
        // 记录数据的实际索引。
        int[] deal = deal(user);
        // 从小到大排序
        Arrays.sort(user);
        // 用于累加的 定位原始数据的索引
        int[] addSum = Arrays.copyOf(user, user.length);
        int i = -1;
        while (k > 0) {
            int min = Integer.MAX_VALUE;
            // 找到最小的索引。
            int minJ = 0;
            for (int j = 0; j < user.length; j++) {
                if (min > user[j]) {
                    min = user[j];
                    i = deal[addSum[j]];
                    minJ = j;
                }
            }
            user[minJ] += addSum[minJ];
            retVal.add(i);
            i = i % (n + 1);
            k--;
        }
        retVal.stream().forEach(System.out::println);
    }


    public static void main(String[] args) {
        test1();
    }
}
