//Reorder List
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = ListNode.create(new int[]{1, 2, 3, 4});
        s.reorderList(head);
        head.print();

        head = ListNode.create(new int[]{1, 2, 3});
        s.reorderList(head);
        head.print();
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        //find the middle node of the list
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = slow;
        slow = slow.next;
        pre.next = null;
        //reverse the second half
        pre = null;
        ListNode prepre;
        while (slow != null) {
            prepre = pre;
            pre = slow;
            slow = slow.next;
            pre.next = prepre;
        }

        ListNode tail = pre;
        pre = head;
        head = head.next;
        do {
            pre.next = tail;
            pre = pre.next;
            tail = tail.next;
            pre.next = head;
            pre = pre.next;
            if (head != null) {
                head = head.next;
            }
        } while (tail != null);
    }

}
