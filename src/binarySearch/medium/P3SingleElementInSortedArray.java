package binarySearch.medium;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 * <p>
 * Return the single element that appears only once.
 * <p>
 * Your solution must run in O(log n) time and O(1) space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 */
public class P3SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3};

        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {

        if (nums.length == 1) return nums[0];

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid == 0)
                return nums[mid];
            if (nums.length - 2 < mid)
                return nums[mid];

            int prev = nums[mid - 1];
            int curr = nums[mid];
            int next = nums[mid + 1];


            if (curr != prev && curr != next)
                return curr;

            if ((mid & 1 )!= 1) {
                if (curr == next) {
                    start = mid + 1;
                } else end = mid - 1;
            }else {
                if (curr != next) {
                    start = mid + 1;
                } else end = mid - 1;
            }


        }

        return -1;
    }
}
