//Merge Two Sorted Lists
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.mergeTwoLists(ListNode.create(new int[]{2, 12, 22, 42}),
                ListNode.create(new int[]{3, 13, 23, 33})).print();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        ListNode cur = null;
        while (l1 != null || l2 != null) {
            boolean minIs1;
            if (l1 == null) minIs1 = false;
            else if (l2 == null) minIs1 = true;
            else minIs1 = l1.val < l2.val;

            if (head == null) {
                head = minIs1 ? l1 : l2;
                cur = head;
            } else {
                cur.next = minIs1 ? l1 : l2;
                cur = cur.next;
            }
            if (minIs1) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        return head;
    }
}
