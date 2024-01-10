package dev.luka.leetcode.problems;

import java.util.Stack;

public class BalancedBinaryTree_110 {

    // Returning -1 implies the tree or subtree is height-unbalanced.
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalancedDFSIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> heights = new Stack<>();
        stack.push(root);
        heights.push(1);

        int leftHeight, rightHeight;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int height = heights.pop();

            if (node.left == null && node.right == null) {
                if (heights.isEmpty()) {
                    continue;
                }
                leftHeight = heights.peek();
                rightHeight = height;
            } else {
                leftHeight = node.left != null ? height + 1 : 0;
                rightHeight = node.right != null ? height + 1 : 0;
                stack.push(node.left);
                stack.push(node.right);
                heights.push(leftHeight);
                heights.push(rightHeight);
            }

            if (Math.abs(leftHeight - rightHeight) > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BalancedBinaryTree_110 binaryTree = new BalancedBinaryTree_110();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(binaryTree.isBalanced(root));
        System.out.println(binaryTree.isBalancedDFSIterative(root));
    }

}
