//Insertion Sort List
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.insertionSortList(ListNode.create(new int[]{1,2,3,4,5})).print();
        s.insertionSortList(ListNode.create(new int[]{5,4,3,2,1})).print();
        s.insertionSortList(ListNode.create(new int[]{1,3,5,2,4})).print();
        s.insertionSortList(ListNode.create(new int[]{1})).print();
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode root = head;
        ListNode cur = head.next;
        root.next = null;
        while (cur != null) {
            ListNode rootCur = root;
            ListNode rootPre = null;
            ListNode next = cur.next;
            while (rootCur != null && rootCur.val < cur.val) {
                rootPre = rootCur;
                rootCur = rootCur.next;
            }
            if (rootPre == null) {
                rootPre = cur;
                cur.next = rootCur;
                root = rootPre;
            } else {
                rootPre.next = cur;
                cur.next = rootCur;
            }
            cur = next;
        }
        return root;
    }

}
