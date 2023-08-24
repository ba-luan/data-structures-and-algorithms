package dev.luka.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // Use Hashmap to loop throught the array once.
            Map<Integer, Integer> map = new HashMap<>();
            // Store number in nums as key and its index as value to the hashmap.
            for(int i = 0; i <= nums.length; i++) {
                int complement = target - nums[i];
                if(map.containsKey(complement)){
                    return new int[] {map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }
}
