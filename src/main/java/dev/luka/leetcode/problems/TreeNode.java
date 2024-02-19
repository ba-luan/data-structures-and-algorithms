package dev.luka.leetcode.problems;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void printBinaryTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]"); // Print empty array if the tree is empty
            return;
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val);
                    sb.append(", ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append("null, ");
                }
            }
        }

        // Remove the trailing ", " and enclose the string in square brackets
        sb.delete(sb.length() - 2, sb.length());
        sb.insert(0, "[");
        sb.append("]");

        System.out.println(sb.toString());
    }
}
