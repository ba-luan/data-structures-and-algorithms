package dev.luka.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    private Map<Integer, Integer> map = new HashMap<>();
    private Integer preorderIndex = 0;
    public TreeNode buildTreeRecursive(int[] preorder, int[] inorder) {
        // create a map for val/index pairs of the Inorder array
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // This helper method is recursively invoked in the order root -> left node -> right node
        // each time it reaches a node and increments preorderIndex pointer, its value will match with
        // the index of every node in preorder array
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInorder = map.get(rootVal);

        // preorderIndex pointer will be incremented by the exact size of the left subtree after it escapes
        // the root.left (after processing the left subtree), and at the right position (the start of right subtree)
        // in the preorder array when going to the root.right processing.
        root.left = buildTreeHelper(preorder, inorder, inStart, rootIndexInorder - 1);
        root.right = buildTreeHelper(preorder, inorder, rootIndexInorder + 1, inEnd);

        return root;
    }


    // This is method is more intuitive comparing to its above version because we manually calculate
    // the indexes of the left and right subtree roots (preStart pointer) in the preorder array
    // instead of updating preorderIndex pointer
    public TreeNode buildTreeRecursiveV2(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInorder = map.get(rootVal);
        int leftSubtreeSize = rootIndexInorder - inStart;

        // if we go further into the left branch, the preStart/preorderIndex increase by 1
        // otherwise, if we go to the right branch, we need to jump leftSubtreeSize step ahead
        root.left = buildTreeHelper(preorder, preStart + 1, inorder, inStart, rootIndexInorder - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, inorder, rootIndexInorder + 1, inEnd);

        return root;
    }

    public TreeNode buildTreeIterative(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderValue = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderValue);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderValue);
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        var solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal_105();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root1 = solution.buildTreeRecursive(preorder, inorder);
        TreeNode root2 = solution.buildTreeRecursive(preorder, inorder);
        TreeNode root3 = solution.buildTreeIterative(preorder, inorder);
        TreeNode.printBinaryTree(root1);
        TreeNode.printBinaryTree(root2);
        TreeNode.printBinaryTree(root3);
    }
}
