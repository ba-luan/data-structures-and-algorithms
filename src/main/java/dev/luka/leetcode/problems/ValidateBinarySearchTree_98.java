package dev.luka.leetcode.problems;

import java.util.Stack;

public class ValidateBinarySearchTree_98 {

    public boolean isValidBSTIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        Integer prev = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (prev != null && prev >= cur.val)
                return false;

            prev = cur.val;
            cur = cur.right;
        }

        return true;
    }

    public boolean isValidBSTRecursive(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ( (min != null && node.val <= min) || (max != null && node.val >= max) ) {
            return false;
        }

        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
