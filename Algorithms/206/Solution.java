public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode node = ListNode.create(new int[]{1, 2, 3, 4, 5});
        node.print();
        s.reverseList(node).print();
    }

    public ListNode reverseList(ListNode head) {
        //iteratively

        if (head == null) return null;
        ListNode reversed = null;
        while (head != null) {
            if (reversed == null) {
                reversed = head;
                head = head.next;
                reversed.next = null;
            } else {
                ListNode tmp = head;
                head = head.next;
                tmp.next = reversed;
                reversed = tmp;
            }
        }
        return reversed;


        //recursively
        /*
        if (head == null) return null;
        if(head.next == null) {
            return head;
        }else{
            ListNode tmp = reverseList(head.next);
            ListNode cur = tmp;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = head;
            head.next = null;
            return tmp;
        }
        */
    }
}
