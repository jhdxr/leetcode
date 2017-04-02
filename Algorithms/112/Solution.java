//Path Sum 
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(s.hasPathSum(root, 22));
        System.out.println(s.hasPathSum(root, 100));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        queue.offer(root);
        sumQueue.offer(0);
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            int sumNow = sumQueue.poll() + node.val;
            if (sumNow == sum && node.left == null && node.right == null) {
                return true;
            }
            if (node.left != null) {
                queue.offer(node.left);
                sumQueue.offer(sumNow);
            }
            if (node.right != null) {
                queue.offer(node.right);
                sumQueue.offer(sumNow);
            }
        }
        return false;
    }

}
