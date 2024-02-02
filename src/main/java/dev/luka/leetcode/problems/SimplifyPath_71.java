package dev.luka.leetcode.problems;

import java.util.Stack;

public class SimplifyPath_71 {

    // Use extra memory String array => Space Complexity: O(2n)
    public static String simplifyPath(String path) {
        String[] directories = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String dir : directories) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.push(dir);
            }
        }

        // if path is "/../" of contains only "/" or "." (i.e. /../././//),
        // stack will be empty, then we can return root directory "/"
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.append("/").append(dir);
        }

        return res.toString();
    }

    public static String simplifyPathV2(String path) {
        StringBuilder result = new StringBuilder();
        int n = path.length();

        // Stack to store valid components
        Stack<String> stack = new Stack<>();

        // Process each character in the path
        for (int i = 0; i < n; i++) {
            // Skip consecutive '/'
            while (i < n && path.charAt(i) == '/') {
                i++;
            }

            // Extract the current component
            StringBuilder component = new StringBuilder();
            while (i < n && path.charAt(i) != '/') {
                component.append(path.charAt(i));
                i++;
            }

            // Process the current component
            String current = component.toString();
            if (current.equals("..")) {
                // If '..', pop the last component if the stack is not empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!current.isEmpty() && !current.equals(".")) {
                // If not empty or '.', push the component to the stack
                stack.push(current);
            }
        }

        // Construct the simplified canonical path
        for (String component : stack) {
            result.append("/").append(component);
        }

        // Return the simplified canonical path or "/" if empty
        return result.isEmpty() ? "/" : result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Simplify V1:");
        System.out.println(simplifyPath("/home/")); // Output: /home
        System.out.println(simplifyPath("/../")); // Output: /
        System.out.println(simplifyPath("/home//foo/")); // Output: /home/foo
        System.out.println("Simplify V2:");
        System.out.println(simplifyPathV2("/home/")); // Output: /home
        System.out.println(simplifyPathV2("/../")); // Output: /
        System.out.println(simplifyPathV2("/home//foo/")); // Output: /home/foo
    }
}
