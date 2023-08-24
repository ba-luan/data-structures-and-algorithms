package dev.luka.leetcode.problems;

public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        int lastWordLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                lastWordLen++;
            } else {
                // check lastWordLen before return in case there's space(s) at the end of String s.
                if (lastWordLen > 0) return lastWordLen;
            }
        }
        // if String s has only one word then return lastWordLen
        return lastWordLen;
    }

}
