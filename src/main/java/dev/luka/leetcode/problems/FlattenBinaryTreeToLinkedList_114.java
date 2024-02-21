package dev.luka.leetcode.problems;

public class FlattenBinaryTreeToLinkedList_114 {

    // Time Complexity O(n^2)
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left; // link left branch to the right side
        root.left = null; // unlink left branch

        // traverse to the end of the new right branch, this makes O(n^2) time complexity
        while (root != null && root.right != null)  {
            root = root.right;
        }

        root.right = temp; // link the original right branch to the end of new right branch
    }

    // Time complexity O(n) as it visits each node exactly once
    public void flattenV2(TreeNode root) {
        if (root == null) return;
        flattenTree(root);
    }


    private TreeNode flattenTree(TreeNode node) {
        if (node == null) return null;

        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        // link the left branch to the right branch
        if (node.left != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // if there's rightTail, then return it, or else return leftTail or else return node
        return rightTail != null ? rightTail : (leftTail != null ? leftTail : node);
    }

    public static void main(String[] args) {
        var sol = new FlattenBinaryTreeToLinkedList_114();
        sol.flatten(new TreeNode(0));
//        sol.flatten(new TreeNode(1));
    }
}
