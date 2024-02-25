package dev.luka.leetcode.problems;

public class LowestCommonAncestorOfBinarySearchTree_235 {

    // Because we only visit 1 one per tree level then go down to one of the subtree
    // Time O(H) where H is the height of the tree or O(logN) when tree is balanced
    // Similarly, Space O(H) or O(logN)
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorRecursive(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorRecursive(root.right, p, q);
        }
        else {
            return root;
        }
    }

    // Time and Space O(H) or O(logN)
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            else {
                return root;
            }
        }
        return null;
    }
}
