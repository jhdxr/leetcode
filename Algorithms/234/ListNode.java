/**
 * Created by xiami on 3/11/2016.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void print() {
        ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val + "=>");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode create(int[] arr) {
        ListNode head = null;
        ListNode cur = null;
        for (int i : arr) {
            if (head == null) {
                head = new ListNode(i);
                cur = head;
            } else {
                cur.next = new ListNode(i);
                cur = cur.next;
            }
        }
        return head;
    }
}
