package dev.luka.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    // Time O(n log n); Space O(1)
    public int majorityElementUsingSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }

    // Time O(n); Space O(n)
    public int majorityElementUsingHashMap(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        n = n / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        // problem prompt assumes that majority element always exists
        // this return will never be reached.
        return 0;
    }

    // Time O(n); Space O(1)
    // This Algorithm only works if the majority is guaranteed.
    public int majorityElementUsingMooreVoting(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
//            count += (num == candidate ? 1 : -1); // alternative for if-else condition above
        }

        return candidate;
    }

    public static void main(String[] args) {
        var sol = new MajorityElement_169();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(sol.majorityElementUsingSort(nums));
        System.out.println(sol.majorityElementUsingHashMap(nums));
        System.out.println(sol.majorityElementUsingMooreVoting(nums));

        nums = new int[]{3, 2, 3};
        System.out.println(sol.majorityElementUsingSort(nums));
        System.out.println(sol.majorityElementUsingHashMap(nums));
        System.out.println(sol.majorityElementUsingMooreVoting(nums));
    }
}
