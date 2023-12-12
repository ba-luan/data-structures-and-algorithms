package dev.luka.leetcode.problems;

import java.util.*;

public class ValidParentheses_20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false; // char c is a closing bracket and stack is empty should be false.
                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /*
    * cons of this method is if String s is a very large and only contains open parentheses,
    * space complexity will become O(2n). Worst case will be the same to other solutions,
    * but Average case takes more memory.
    * */
    public static boolean isValidV2(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    // Use HashMap
    public static boolean isValidHashMap(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c : s.toCharArray()) {
            // check if c is a closing parenthesis
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == map.get(c)) stack.pop();
                else return false;
            }
            else stack.push(c); // always push opening parentheses to the stack
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false

        System.out.println(isValidV2("()")); // true
        System.out.println(isValidV2("()[]{}")); // true
        System.out.println(isValidV2("(]")); // false

        System.out.println(isValidHashMap("()")); // true
        System.out.println(isValidHashMap("()[]{}")); // true
        System.out.println(isValidHashMap("(]")); // false
    }
}
