package base;

/**
 * 排序模板
 */
public class Sorted {
    // java里一定要用buffRead 不要用scanner
    void quick(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = array[left + right >> 1], i = left - 1, j = right + 1;
        while (i < j) {
            while (array[++i] < mid) ;
            while (array[--j] > mid) ;
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        quick(array, left, j);
        quick(array, j + 1, right);
    }

    public static void main(String[] args) {
        Sorted sorted = new Sorted();
        int[] arr = {3, 1, 2, 3, 4, 54, 4, 3, 31, 4};
        sorted.quick(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
