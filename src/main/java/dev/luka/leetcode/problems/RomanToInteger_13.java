package dev.luka.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            // check up to the second last character.
            if (i < s.length() - 1 && (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))){
                ans -= map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i));
            }
        }
        return ans;
    }

    public int romanToIntNoHashMap(String s) {
        // it seems this runs faster than with HashMap, maybe array's operation is faster than HashMap's.
        int[] romanValues = new int[26];
        romanValues['I' - 'A'] = 1;
        romanValues['V' - 'A'] = 5;
        romanValues['X' - 'A'] = 10;
        romanValues['L' - 'A'] = 50;
        romanValues['C' - 'A'] = 100;
        romanValues['D' - 'A'] = 500;
        romanValues['M' - 'A'] = 1000;
        int sum = 0;
        int prevValue = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int currValue = romanValues[ch - 'A'];
            if (currValue > prevValue) {
                sum -= 2 * prevValue; // because we always add current value first, so we have to subtract twice when we move to next char.
            }
            sum += currValue;
            prevValue = currValue;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(RomanToInteger_13.romanToInt("XI"));
        System.out.println('I' - 'A');
    }

}
