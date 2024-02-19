package dev.luka.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal_889 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePostRecursive(int[] pre, int[] post) {
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return buildTree(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode buildTree(int[] pre, int preStart, int preEnd,
                               int[] post, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        int leftRootVal = pre[preStart + 1];
        int leftRootIndex = map.get(leftRootVal);
        int leftSubtreeSize = leftRootIndex - postStart + 1;

        root.left = buildTree(pre, preStart + 1, preStart + leftSubtreeSize,
                post, postStart, leftRootIndex);
        root.right = buildTree(pre, preStart + leftSubtreeSize + 1, preEnd,
                post, leftRootIndex + 1, postEnd - 1);

        return root;
    }

    public TreeNode constructFromPrePostIterative(int[] pre, int[] post) {
        if (pre.length == 0 || post.length == 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(pre[0]);
        stack.push(root);

        int postIndex = 0;
        for (int i = 1; i < pre.length; i++) {
            TreeNode node = new TreeNode(pre[i]);
            while (stack.peek().val == post[postIndex]) {
                stack.pop();
                postIndex++;
            }
            if (stack.peek().left == null) {
                stack.peek().left = node;
            } else {
                stack.peek().right = node;
            }
            stack.push(node);
        }

        return root;
    }

}
