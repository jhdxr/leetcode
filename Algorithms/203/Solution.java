//Remove Linked List Elements 
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.removeElements(ListNode.create(new int[]{5, 1, 2, 5, 3, 4, 5}), 5).print();
        s.removeElements(ListNode.create(new int[]{1, 2, 2, 1}), 2).print();
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (cur.val == val) { //need remove
                if (cur == head) { //current node is head
                    head = head.next;
                } else { //remove current node
                    pre.next = cur.next;
                    cur = pre;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

}
