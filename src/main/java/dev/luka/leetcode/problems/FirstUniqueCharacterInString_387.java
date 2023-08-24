package dev.luka.leetcode.problems;

import java.util.HashMap;

public class FirstUniqueCharacterInString_387 {

    public static int firstUniqChar_bruteforce(String s) {
        boolean isRepeated = false;
        for(int i = 0;i<s.length(); i++){
            for(int j = 0; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && i!=j){
                    isRepeated = true;
                    break;
                }
            }
            if (isRepeated == true) isRepeated = false; // if there's a repeated char, then reset isRepeated flag and start new iteration.
            else return i; // the inner for loop is completed and isRepeated == false that mean this is the first unique char.
        }
        return -1;
    }

    public static int firstUniqChar_hashMap(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            // use map.getOrDefaults() to count the occurrences of char
            // if encounter char the first time, means char doesn't exist before, put value as 0 + 1
            // each of later encounters will be increased by 1.
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);

            // or we do as below to increase readability.
//            map.put(s.charAt(i), map.get(s.charAt(i)) == null ? 1 : (map.get(s.charAt(i)) + 1));
        }
        for(int i = 0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1)return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar_bruteforce("aabc"));
        System.out.println(firstUniqChar_hashMap("aabc"));
    }
}
