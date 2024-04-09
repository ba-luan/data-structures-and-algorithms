package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, "", res, n);
        return res;
    }

    private void backtrack(int openParenthesis, int closeParenthesis, String combination, List<String> result, int n) {
        if (combination.length() == n * 2) {
            result.add(combination);
            return;
        }

        if (openParenthesis < n) {
            backtrack(openParenthesis + 1, closeParenthesis, combination + "(", result, n);
        }

        if (closeParenthesis < openParenthesis) {
            backtrack(openParenthesis, closeParenthesis + 1, combination + ")", result, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses_22 sol = new GenerateParentheses_22();
        System.out.println(sol.generateParenthesis(3));
    }


}
