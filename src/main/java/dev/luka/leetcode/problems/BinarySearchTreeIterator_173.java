package dev.luka.leetcode.problems;

import java.util.Stack;

public class BinarySearchTreeIterator_173 {
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator_173(TreeNode root) {
        stack = new Stack<>();
        pushLeftNodes(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop(); // may throw EmptyStackException but the problem's assumption ensure next() always be valid
        pushLeftNodes(node.right); // push all left nodes of the right branch to stack
        return node.val;
    }

    private void pushLeftNodes(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
