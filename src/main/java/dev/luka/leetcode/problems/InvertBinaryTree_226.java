package dev.luka.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 {

    // Due to traverse and store all node => Time and Space Complexity: O(n)
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);

        return root;
    }

    // Worst case when Tree is one branch biased: Time and Space O(n)
    // Best case when Tree is complete balanced: Space O(h) which h is the height of the tree
    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
    }
}