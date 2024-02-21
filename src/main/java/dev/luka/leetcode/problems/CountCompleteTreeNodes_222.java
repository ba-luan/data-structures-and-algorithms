package dev.luka.leetcode.problems;

public class CountCompleteTreeNodes_222 {

    // Recursive version with Time Complexity O(n) looping to every node in the tree
    public int countNodesV2(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodesV2(root.left) + countNodesV2(root.right);
    }

    /*
    * Time Complexity: O(log(n)^2) where n is the number of nodes in the tree
    * The algorithm traverses down to the leftmost and right most nodes which takes O(log(n)) each branch
    * This process repeats on each level and there are log(n) levels
    * */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) {
            // If the left subtree and right subtree have the same height,
            // the tree is a full binary tree, and the number of nodes can be calculated directly
            // using the formula (2^h)-1 which is equivalent to the bitwise operation below.
            return (1 << leftHeight) - 1;
        } else {
            // If the left subtree and right subtree have different heights,
            // recursively count the nodes in the left and right subtrees.
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

}
