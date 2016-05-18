//Palindrome Linked List
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPalindrome(ListNode.create(new int[]{1, 2, 3}))); //false
        System.out.println(s.isPalindrome(ListNode.create(new int[]{1, 2, 3, 4}))); //false
        System.out.println(s.isPalindrome(ListNode.create(new int[]{1, 2, 3, 2, 1}))); //true
        System.out.println(s.isPalindrome(ListNode.create(new int[]{1, 2, 2, 1}))); //true
        System.out.println(s.isPalindrome(ListNode.create(new int[]{1}))); //true
        System.out.println(s.isPalindrome(ListNode.create(new int[]{1, 2}))); //false
        System.out.println(s.isPalindrome(ListNode.create(new int[]{1, 1}))); //true

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        ListNode prepre;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prepre = pre;
            pre = slow;
            slow = slow.next;
            pre.next = prepre;
        }
        head = slow.next;
        slow.next = pre;
        if (fast.next == null) { //we have 2n+1 nodes
            slow = slow.next;
        } else { //we have 2n nodes
        }
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

}
