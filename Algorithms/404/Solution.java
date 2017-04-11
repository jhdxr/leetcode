//Sum of Left Leaves 
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s.sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode now = queue.poll();
            if (now.left != null) {
                if (now.left.left == null && now.left.right == null) {
                    sum += now.left.val;
                } else {
                    queue.offer(now.left);
                }
            }
            if(now.right != null && (now.right.left != null || now.right.right != null)){
                queue.offer(now.right);
            }
        }
        return sum;
    }

}
