//Path Sum III 

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        System.out.println(s.pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Queue<PathVal> queue = new LinkedList<>();
        final int[] count = {0};
        queue.offer(PathVal.newRoot(root));
        while (queue.peek() != null) {
            PathVal current = queue.poll();
            TreeNode node = current.node;
            current.currentPathVal.forEach(val -> {
                count[0] += val == sum ? 1 : 0;
            });
            if (node.left != null) {
                queue.offer(PathVal.calcNextPathVal(current, node.left));
            }
            if (node.right != null) {
                queue.offer(PathVal.calcNextPathVal(current, node.right));
            }
        }
        return count[0];
    }

    private static class PathVal {
        public TreeNode node;
        public List<Integer> currentPathVal;

        public PathVal(TreeNode node, List<Integer> currentPathVal) {
            this.node = node;
            this.currentPathVal = currentPathVal;
        }

        public static PathVal newRoot(TreeNode node) {
            PathVal root = new PathVal(node, new ArrayList<>());
            root.currentPathVal.add(node.val);
            return root;
        }

        public static PathVal calcNextPathVal(PathVal old, TreeNode node) {
            PathVal next = newRoot(node);
            old.currentPathVal.forEach(i -> {
                next.currentPathVal.add(i + node.val);
            });
            return next;
        }
    }

}
