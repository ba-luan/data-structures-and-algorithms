package dev.luka.leetcode.problems;

import java.util.Stack;

public class SameTree_100 {

    /*
     * Time Complexity O(p + q) - total of nodes in both trees
     * Space Complexity O(p + q) - worst case the stack needs to store all the nodes of both trees
     * */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base cases
        // Need to follow this exact order
        if (p == null && q == null) return true;
        // if both of them are NOT null, it is sufficed that we can only check next if ONE of them is Null
        // instead of check these two conditions (p != null && q == null) || (p == null && q != null)
        if (p == null || q == null) return false;
        // to this step, both of them are NOT null, then we check their values
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeDFSInorder(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()) {
            TreeNode nodeQ = stack.pop();
            TreeNode nodeP = stack.pop();

            if (nodeP == null && nodeQ == null) continue;
            if (nodeQ == null || nodeQ == null || nodeP.val != nodeQ.val) return false;

            stack.push(nodeP.left);
            stack.push(nodeQ.left);
            stack.push(nodeP.right);
            stack.push(nodeQ.right);
        }

        return true;
    }

    public static void main(String[] args) {
        SameTree_100 sameTree = new SameTree_100();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(sameTree.isSameTree(p , q));
        System.out.println(sameTree.isSameTreeDFSInorder(p , q));
    }
}
