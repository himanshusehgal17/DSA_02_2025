package array.easy;

/**
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * <p>
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * Link: https://leetcode.com/problems/majority-element/description/
 */

public class P1MajorityElement {
    public static void main(String[] args) {

        int[] nums = {2, 1, 1, 1, 2};
        System.out.println(findMajorityElement(nums));
    }

    private static int findMajorityElement(int[] nums) {

        int ans = 0;
        int freq = 0;

        for (int num : nums) {

            if (freq == 0)
                ans = num;

            if (num == ans)
                freq++;
            else freq--;

        }

        return ans;

    }
}
