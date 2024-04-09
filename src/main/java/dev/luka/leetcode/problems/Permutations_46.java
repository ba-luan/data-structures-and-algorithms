package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), res, nums);
        return res;
    }

    private void backtrack(List<Integer> permutation, List<List<Integer>> result, int[] nums) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }
            permutation.add(nums[i]);
            backtrack(permutation, result, nums);
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations_46 sol = new Permutations_46();
        System.out.println(sol.permute(new int[]{1,2,3}).toString());
    }
}
