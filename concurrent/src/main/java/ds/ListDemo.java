package ds;

public class ListDemo {
    public static void main(String[] args) {
        ListNoe first = new ListNoe(1);
        ListNoe second = new ListNoe(2);
        first.next = second;
        while (first != null) {
            System.out.println(first.val);
            first = first.next;
        }
    }
}

// 定义链表结点
class ListNoe {
    int val;
    ListNoe next = null;

    public ListNoe(int val) {
        this.val = val;
        this.next = null;
    }
}