package dev.luka.leetcode.problems;

public class LowestCommonAncestorOfBinaryTree_236 {

    // Time O(N) and Space O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Constraints ensure p and q exist in the tree => if root equals to one of them, root is LCA
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both left and right LCA are not null, then root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If only one of the subtrees returns a non-null LCA, or both are null, propagate it upwards
        return leftLCA != null ? leftLCA : rightLCA;
    }
}
