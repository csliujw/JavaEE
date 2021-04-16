package ds;

import java.util.Map;

/**
 * 字典树
 */
public class Trie {

    // 是否存在，能搜索完不就好了
    static class Node {
        boolean isEnd = false;
        // 不考虑大小写。不包含特殊字符
        Node next[] = new Node[26];
        // 考虑各种字符
        Map<Character, Node> map;

        // TreeMap Red-Black tree
    }
}
