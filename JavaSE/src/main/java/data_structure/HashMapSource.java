package data_structure;

import java.util.HashMap;

public class HashMapSource {
    public static void main(String[] args) {
        /**
         * 数组+单链表<br>
         * jdk8中引入了红黑树对长度 > 8的链表进行优化<br>
         */
        HashMap<String, String> map = new HashMap<>();
        map.put("123", "123");
    }
}
