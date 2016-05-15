//Linked List Cycle II 
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

    }

    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while(q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if(p == q) {
                q = head;
                while(p != q) {
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }

}
