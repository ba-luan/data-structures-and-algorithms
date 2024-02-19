package dev.luka.leetcode.problems;

public class PathSum_112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: empty tree or algorithm reaches a leaf node
        if (root == null)
            return false;
        // Reach the leaf node which is also the correct path
        if (root.left == null && root.right == null && root.val == targetSum)
            return true;
        // Recursive calls for the left and right subtrees with updated target sums.
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
