//Reverse Nodes in k-Group
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.reverseKGroup(ListNode.create(new int[]{1, 2, 3, 4, 5}), 2).print();
        s.reverseKGroup(ListNode.create(new int[]{1, 2, 3, 4, 5}), 3).print();
        s.reverseKGroup(ListNode.create(new int[]{1, 2}), 3).print();
        s.reverseKGroup(ListNode.create(new int[]{1, 2}), 2).print();
        s.reverseKGroup(ListNode.create(new int[]{1, 2}), 1).print();
        s.reverseKGroup(ListNode.create(new int[]{1, 2}), 0).print();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        ListNode newHead = null;
        ListNode newTail = null;

        cur = head;
        while ((len -= k) >= 0) { // for each complete group
            ListNode root = cur; // head of this group
            ListNode prepre = null;
            ListNode pre = cur;
            for (int i = 0; i < k; i++) { //reverse k nodes
                cur = cur.next;
                pre.next = prepre;
                prepre = pre;
                pre = cur;
            }
            if (newHead == null) {
                newHead = prepre;
            } else {
                newTail.next = prepre;
            }
            newTail = root;
        }
        if (newHead == null) {
            newHead = head;
        } else {
            newTail.next = cur;
        }
        return newHead;
    }
}
