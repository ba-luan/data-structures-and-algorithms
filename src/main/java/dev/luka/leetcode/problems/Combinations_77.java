package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int n, int k, List<Integer> combination, List<List<Integer>> result) {
        // goal case
        if (combination.size() == k) {
            // do deep-copy (initializing a new list) before adding to result list
            // otherwise shallow-copy makes final returned list an empty list
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n; i++) {
            combination.add(i);
            backtrack(i + 1, n, k, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations_77 sol = new Combinations_77();
        System.out.println(sol.combine(4, 2).toString());
    }
}
