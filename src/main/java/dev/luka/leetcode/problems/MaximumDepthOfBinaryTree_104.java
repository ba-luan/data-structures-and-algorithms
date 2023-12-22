package dev.luka.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree_104 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int maxDepthRecursiveDFS(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepthRecursiveDFS(root.left);
        int rightDepth = maxDepthRecursiveDFS(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static int maxDepthIterativeDFS(TreeNode root) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        stack.push(root);
        depths.push(1);
        int maxDepth = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int depth = depths.pop();
            maxDepth = Math.max(maxDepth, depth);

            if (node.right != null) {
                stack.push(node.right);
                depths.push(depth + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                depths.push(depth + 1);
            }
        }
        return maxDepth;
    }

    public static int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthOfBinaryTree_104 maxDepthFinder = new MaximumDepthOfBinaryTree_104();

        // Using Recursive DFS
        int maxDepthRecursive = maxDepthFinder.maxDepthRecursiveDFS(root);
        System.out.println("Maximum Depth (Recursive DFS): " + maxDepthRecursive);

        // Using Iterative DFS
        int maxDepthIterative = maxDepthFinder.maxDepthIterativeDFS(root);
        System.out.println("Maximum Depth (Iterative DFS): " + maxDepthIterative);

        // Using BFS
        int maxDepthBFS = maxDepthFinder.maxDepthBFS(root);
        System.out.println("Maximum Depth (BFS): " + maxDepthBFS);
    }

}



