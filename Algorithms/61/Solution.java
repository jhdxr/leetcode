//Rotate List
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.rotateRight(ListNode.create(new int[]{1, 2, 3, 4, 5}), 2).print();
        s.rotateRight(ListNode.create(new int[]{1, 2}), 3).print();
        s.rotateRight(ListNode.create(new int[]{1, 2}), 2).print();
        s.rotateRight(ListNode.create(new int[]{1, 2}), 1).print();
        s.rotateRight(ListNode.create(new int[]{1, 2}), 0).print();
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        if (head == null || k <= 0 || k % length == 0) return head;
        k = k % length;

        cur = head;
        int i = length - k;
        while (--i > 0) cur = cur.next;
        ListNode ret = cur.next;
        cur.next = null;
        cur = ret;
        while (cur.next != null) cur = cur.next;
        cur.next = head;
        return ret;
    }

}
