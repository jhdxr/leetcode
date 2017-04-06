//Path Sum II
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
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> ansArr = s.pathSum(root, 22);
        ansArr.stream().forEach(ans -> {
            ans.stream().forEach(System.out::println);
            System.out.println();
            System.out.println();
            System.out.println();
        });
    }

    private Stack<Integer> currentPath;
    private List<List<Integer>> answer;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        currentPath = new Stack<>();
        answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        solve(root, sum);
        return answer;
    }

    private void solve(TreeNode root, int sum) {
        currentPath.push(root.val);
        sum -= root.val;
        try {
            if (sum == 0 && root.left == null && root.right == null) {
                answer.add(new ArrayList<>(currentPath));
                return;
            }
            if (root.left != null) {
                solve(root.left, sum);
            }
            if (root.right != null) {
                solve(root.right, sum);
            }
        } finally {
            currentPath.pop();
        }
    }

}
