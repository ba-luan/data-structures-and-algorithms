package dev.luka.leetcode.problems;

import java.util.Stack;

public class KthSmallestElementInBST_230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int count = 0;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            count++;

            if (count == k) return cur.val;

            cur = cur.right;
        }

        return Integer.MIN_VALUE; // dummy return statement to avoid compiler's complaint
    }
}
