package ds;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Demo3 {
    public static void main(String[] args) {
        int T = 1;
        int n = 03;
        int t1 = 3, t2 = 1, t3 = 1;
        int w1 = 3, w2 = 6, w3 = 9;
        // 算出相对的惩罚值？
        int[] abs = new int[n];
        int[] map = new int[65535 + 2];
        double[] arr = {t1 * 1.0 / w1, t2 * 1.0 / w2, t3 * 1.0 / w3};
        // 排序后要保存原始索引
        int[] tmp = new int[n];
        for (int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for (int j = k + 1; j < arr.length; j++) {// 选最小的记录
                if (arr[j] < arr[k]) {
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != k) {  //交换a[i]和a[k]
                double temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
            tmp[i] = k;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            // 从小到大选值
            if (Math.abs(arr[i] - arr[i + 1]) < 1e-8) {
                // 说明两数相等。
            }
            System.out.println(arr[i]);
        }
        for (int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i]);
        }
    }

    static void demo() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int max = sc.nextInt();

        // 重量
        int[] hight = new int[num + 1];
        // 钱
        int[] money = new int[num + 1];
        //输入重量
        for (int i = 1; i <= num; i++) {
            hight[i] = sc.nextInt();
        }
        //输入重量
        for (int i = 1; i <= num; i++) {
            money[i] = sc.nextInt();
        }
        //创建num+1个背包，背包能承受的重量为max（0不包括，从1 开始）
        int[][] arr = new int[num + 1][max + 1];

        //arr[0]第一个背包什么都不装所以不遍历（全为0）;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= max; j++) {
                //当前共有i个物品
                //如果当前的背包承受重量 j 大于第 i 个物品的重量，
                if (i > 0 && hight[i] <= j) {
                    //那么对比上一个背包的当前背包承受重量的最大值 和 上一个背包减去当前 i 物品的重量hight[i]，并加上 i 物品的价值money[i]，
                    //就相当于把上个背包承受重量减去 i 的重量，这样就刚刚能塞下 i 物品，
                    //因为塞下 i 物品，所以在加上 i 物品的重量。
                    //添加 i 物品和不添加 i 物品的价值对比。
                    if (arr[i - 1][j] > (arr[i - 1][j - hight[i]] + money[i])) {
                        //如果不添加i物品的价值最大的话，那么当前的背包数量等于不添加物品的价值
                        arr[i][j] = arr[i - 1][j];
                    } else {
                        //如果添加 i 物品的价值大的话那么当前j背包数量的价值就等于添加i物品后的价值。
                        arr[i][j] = arr[i - 1][j - hight[i]] + money[i];
                    }
                } else {
                    //如果当前背包装不下i物品那么当前背包价值等于上一个背包当前重量的价值。
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }
    }
}
