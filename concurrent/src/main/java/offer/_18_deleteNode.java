package offer;

public class _18_deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tmp = dummy;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
