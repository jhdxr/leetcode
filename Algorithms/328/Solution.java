public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode l = ListNode.create(new int[]{1, 2, 3, 4, 5});
        l.print();
        s.oddEvenList(l).print();
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        boolean isOdd = true;
        ListNode odd = null;
        ListNode oddHead = null;
        ListNode even = null;
        ListNode evenHead = null;
        while (head != null) {
            if (isOdd) {
                if (oddHead == null) {
                    odd = head;
                    oddHead = odd;
                } else {
                    odd.next = head;
                    odd = odd.next;
                }
            } else {
                if (evenHead == null) {
                    even = head;
                    evenHead = even;
                } else {
                    even.next = head;
                    even = even.next;
                }
            }
            isOdd = !isOdd;
            head = head.next;
        }
        odd.next = evenHead;
        if (even != null) {
            even.next = null;
        }
        return oddHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void print() {
            ListNode cur = this;
            while (cur != null) {
                System.out.print(cur.val + "=>");
                cur = cur.next;
            }
            System.out.println();
        }

        public static ListNode create(int[] arr) {
            ListNode head = null;
            ListNode cur = null;
            for (int i : arr) {
                if (head == null) {
                    head = new ListNode(i);
                    cur = head;
                } else {
                    cur.next = new ListNode(i);
                    cur = cur.next;
                }
            }
            return head;
        }
    }
}
