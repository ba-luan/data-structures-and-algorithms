package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {
    private static final String[] LETTERS = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder combination, List<String> result) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = LETTERS[digit - '0'];
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            backtrack(digits, index + 1, combination, result);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public List<String> letterCombinationsV2(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isBlank())
            return result;
        combination("", digits, 0, result);
        return result;
    }

    private void combination(String combination, String digits, int index, List<String> result) {
        // base case or goal case in backtracking
        if (index == digits.length()) {
            result.add(combination);
            return;
        }
        String letters = LETTERS[(digits.charAt(index) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(combination + letters.charAt(i), digits, index + 1, result);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber_17 solution = new LetterCombinationsOfAPhoneNumber_17();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("2"));

        System.out.println(solution.letterCombinationsV2("23"));
        System.out.println(solution.letterCombinationsV2(""));
        System.out.println(solution.letterCombinationsV2("2"));
    }
}
