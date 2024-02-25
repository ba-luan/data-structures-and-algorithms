package dev.luka.leetcode.problems;

public class SumRootToLeafNumbers_129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) return 0;

        sum = sum * 10 + node.val;

        // return when we reach the leaf
        if (node.left == null && node.right == null) {
            return sum;
        }

        return dfs(node.left, sum) + dfs(node.right, sum);
    }
}
