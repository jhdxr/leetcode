//Delete Node in a Linked List
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = ListNode.create(new int[]{1, 2, 3, 4, 5});
        ListNode node = head.next.next;
        s.deleteNode(node);
        head.print(); //1, 2, 4, 5

        s.deleteNode(head);
        head.print(); //2, 4, 5

        node = head.next.next;
        s.deleteNode(node);
        head.print(); //2, 4, 5
    }

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return; //node not exists or is tail
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
