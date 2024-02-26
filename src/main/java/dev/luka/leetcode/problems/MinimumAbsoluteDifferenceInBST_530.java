package dev.luka.leetcode.problems;

import java.util.Stack;

public class MinimumAbsoluteDifferenceInBST_530 {

    public int getMinimumDifference(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        Integer prevValue = null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null | !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (prevValue != null) {
                minDiff = Math.min(minDiff, cur.val - prevValue);
            }

            prevValue = cur.val;
            cur = cur.right;
        }

        return minDiff;
    }
}
