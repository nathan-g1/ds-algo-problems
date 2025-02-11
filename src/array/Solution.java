/*
 * This solution class contains my work on Grind 75 Leetode questions.
 * 
 * Created Date: Feb 11, 2025
 * Author: Nathan Lechamo
 * 
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
    }

    // #1: Two sum
    /*
     * Given an array of integers nums and an integer target, 
     * return indices of the two numbers such that they add up to target.
     * 
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order
     * 
     * Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]
     */
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                return new int[] {map.get(nums[i]), i};
            }
        }
        return new int[] {0, 0}; // we could also throw an exception here
    }
}
