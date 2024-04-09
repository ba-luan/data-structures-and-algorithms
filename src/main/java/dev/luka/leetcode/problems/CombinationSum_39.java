package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    // The problem constraints all elements of candidates are distinct, to skip duplicated combinations,
    // during backtracking process, we only consider candidates starting from the current index "startIndex".
    // We do not backtrack to indices that we have already visited in the current recursion path.
    private void backtrack(int[] candidates, int target, int startIndex, List<Integer> combination, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum_39 sol = new CombinationSum_39();
        System.out.println(sol.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(sol.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(sol.combinationSum(new int[]{2}, 1));
    }
}
