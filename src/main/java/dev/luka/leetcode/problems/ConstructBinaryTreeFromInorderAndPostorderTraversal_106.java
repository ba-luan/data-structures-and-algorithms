package dev.luka.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    private Map<Integer, Integer> map  = new HashMap<>();

    public TreeNode buildTreeRecursive(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

//        Replace for loop with hashmap to find the index of root value in the inorder array
//        int rootIndexInInorder = 0;
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == rootValue) {
//                rootIndexInInorder = i;
//                break;
//            }
//        }
        int rootIndexInInorder = map.get(rootValue);
        int leftSubtreeSize = rootIndexInInorder - inStart;

        root.left = buildTreeHelper(inorder, inStart, rootIndexInInorder - 1, postorder, postStart, postStart + leftSubtreeSize - 1);
        root.right = buildTreeHelper(inorder, rootIndexInInorder + 1, inEnd, postorder, postStart + leftSubtreeSize, postEnd - 1);

        return root;
    }

    public TreeNode buildTreeIterative(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        int inorderIndex = inorder.length - 1;

        for (int i = postorder.length - 2; i >= 0; i--) {
            TreeNode current = new TreeNode(postorder[i]);
            TreeNode parent = null;

            while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                parent = stack.pop();
                inorderIndex--;
            }

            if (parent != null) {
                parent.left = current;
            } else {
                stack.peek().right = current;
            }

            stack.push(current);
        }

        return root;
    }

}
