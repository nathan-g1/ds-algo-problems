/*
 * This solution class contains my work on Grind 75 Leetode questions.
 * https://www.techinterviewhandbook.org/grind75
 * 
 * Created Date: Feb 11, 2025
 * Author: Nathan Lechamo
 * 
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
        isValid("()[]{}");
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

    // #20: Valid Parenthesis
    /*
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.

        Example 1:
        Input: s = "()"
        Output: true

        Example 2:
        Input: s = "()[]{}"
        Output: true
     */
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char d = stack.pop();
                if (d == '[' && c != ']') {
                    return false;
                }
                if (d == '{' && c != '}') {
                    return false;
                }
                if (d == '(' && c != ')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // #21: Merge Two Sorted Lists
    /*
     * You are given the heads of two sorted linked lists list1 and list2.

        Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

        Return the head of the merged linked list.

        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]
        Example 2:

        Input: list1 = [], list2 = []
        Output: []
        Example 3:

        Input: list1 = [], list2 = [0]
        Output: [0]
     */
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        if (list1 == null) {
            head.next = list2;
        } else if (list2 == null) {
            head.next = list1;
        }
        return res.next;
    }
}
