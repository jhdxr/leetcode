//Sort List
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.sortList(ListNode.create(new int[]{1, 2, 3, 4, 5})).print();
        s.sortList(ListNode.create(new int[]{5, 4, 3, 2, 1})).print();
        s.sortList(ListNode.create(new int[]{1, 3, 5, 2})).print();
        s.sortList(ListNode.create(new int[]{1})).print();
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }

    public ListNode merge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode head = null;
        ListNode cur = null;
        while (a != null || b != null) {
            ListNode next;
            next = b == null || a != null && a.val < b.val ? a : b;
            if (head == null) {
                head = next;
                cur = head;
            } else {
                cur.next = next;
                cur = cur.next;
            }
            if (next == a) {
                a = a.next;
            } else {
                b = b.next;
            }
        }
        return head;
    }

}
