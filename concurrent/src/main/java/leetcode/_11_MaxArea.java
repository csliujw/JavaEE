package leetcode;

public class _11_MaxArea {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i <= j; ) {
            int start = height[i];
            int end = height[j];
            int t = (start > end) ? end * (j - i) : start * (j - i);
            max = max > t ? max : t;
            if (start >= end) j--;
            else i++;
        }
        return max;
    }
}
