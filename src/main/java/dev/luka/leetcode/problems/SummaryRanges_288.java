package dev.luka.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_288 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int startRange = nums[i];
            // check if the next number is still in current range meaning greater than 1 compare the previous number
            // if yes, move the pointer and do nothing.
            while (i + 1 < nums.length && (nums[i] + 1 == nums[i + 1]) ) {
                i++;
            }
            if (startRange != nums[i]) {
                res.add("" + startRange + "->" + nums[i]); // add empty string at the beginning to auto convert everything after it to string
            } else {
                res.add("" + startRange);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SummaryRanges_288 solution = new SummaryRanges_288();
        System.out.println(solution.summaryRanges(new int[]{0,1,2,4,5,7})); // Output: ["0->2","4->5","7"]
        System.out.println(solution.summaryRanges(new int[]{0,2,3,4,6,8,9})); // Output: ["0","2->4","6","8->9"]
    }
}
