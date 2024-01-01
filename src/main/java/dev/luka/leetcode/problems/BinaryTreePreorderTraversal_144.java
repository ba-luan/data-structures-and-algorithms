package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* Time Complexity is O(n) because we have to visit all the nodes.
* Space Complexity (Recursive) O(n).
* Space Complexity (Iterative):
* - Worst case: O(n) if tree only has left nodes, stack needs to store all the nodes.
* - Best case: O(h) if tree is a balanced binary tree, h is the height of tree which is equivalent to O(logn).
* */
public class BinaryTreePreorderTraversal_144 {

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preorderTraversal(node.left, res);
        preorderTraversal(node.right, res);
    }

    // This solution requires to store both left and right nodes in the stack, but it doesn't if they are null.
    // space complexity is O(h) because when we go down to 1 level, we pop 1 node and push 2 nodes,
    // equivalent to push 1 node per level.
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }

        return res;
    }

    // Stack only store right nodes even they may be a Null node.
    // space complexity is O(h) because when we go down to 1 level, we always push a node to the stack, even it's null.
    public List<Integer> preorderTraversalIterativeV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur.right); // push right node to stack even it's a null node
                cur = cur.left;
            } else {
                cur = stack.pop();
            }
        }

        return res;
    }


    public static void main(String[] args) {
        BinaryTreePreorderTraversal_144 binaryTree = new BinaryTreePreorderTraversal_144();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(binaryTree.preorderTraversalRecursive(root));
        System.out.println(binaryTree.preorderTraversalIterative(root));
        System.out.println(binaryTree.preorderTraversalIterativeV2(root));
    }
}
