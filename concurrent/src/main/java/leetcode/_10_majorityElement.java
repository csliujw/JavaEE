package leetcode;

import java.util.HashMap;

public class _10_majorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = (nums.length >> 1) + 1;
        int max = 0;
        int key = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]) + 1;
                if (value > max) {
                    key = i;
                }
                max = Math.max(value, max);
                map.put(nums[i], value);
            } else {
                map.put(nums[i], 1);
            }
        }
        if (max >= count) return nums[key];
        return -1;
    }

    public static void main(String[] args) {
        _10_majorityElement majorityElement = new _10_majorityElement();
        int[] a = {6, 6, 6, 7, 7};
        int i = majorityElement.majorityElement(a);
        System.out.println(i);
    }
}
