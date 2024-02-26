package dev.luka.leetcode.problems;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Deque<Integer> levelValues = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();

                if (leftToRight)
                    levelValues.addLast(cur.val);
                else
                    levelValues.addFirst(cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            res.add(new ArrayList<>(levelValues));
            leftToRight = !leftToRight;
        }

        return res;
    }

}
