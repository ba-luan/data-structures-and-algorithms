package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145 {

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postorderTraversal(node.left, res);
        postorderTraversal(node.right, res);
        res.add(node.val);
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null) stack1.push(cur.left);
            if (cur.right != null) stack1.push(cur.right);
        }

        while (!stack2.isEmpty()) res.add(stack2.pop().val);

        return res;
    }

    public List<Integer> postorderTraversalIterativeV2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visit = new Stack<>();
        List<Integer> res = new ArrayList<>();

        stack.push(root);
        visit.push(false);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            Boolean isVisited = visit.pop();
            if (cur != null) {
                if (Boolean.TRUE.equals(isVisited)) {
                    res.add(cur.val);
                } else {
                    stack.add(cur);
                    visit.add(true);
                    stack.push(cur.right);
                    visit.add(false);
                    stack.push(cur.left);
                    visit.add(false);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal_145 binaryTree = new BinaryTreePostorderTraversal_145();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(binaryTree.postorderTraversalRecursive(root));
        System.out.println(binaryTree.postorderTraversalIterative(root));
        System.out.println(binaryTree.postorderTraversalIterativeV2(root));
    }

}
