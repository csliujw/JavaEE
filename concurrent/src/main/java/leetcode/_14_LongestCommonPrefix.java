package leetcode;

public class _14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < prefix.length() && j < strs[i].length(); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) prefix = strs[i].substring(0, j);
            }
            if (prefix.length() > strs[i].length()) prefix = strs[i];
        }
        return prefix;
    }
}
