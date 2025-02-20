package binarySearch.medium;

/**
 * You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
 * <p>
 * Return the index of the peak element.
 * Your task is to solve it in O(log(n)) time complexity.
 * <p>
 * Example 1:
 * Input: arr = [0,1,0]
 * Output: 1
 * <p>
 * Example 2:
 * Input: arr = [0,2,1,0]
 * Output: 1
 * <p>
 * Example 3:
 * Input: arr = [0,10,5,2]
 * Output: 1
 *
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class P2PeakIndexInMountainArray {

    public static void main(String[] args) {

        int[] arr = {0,1,0};

        System.out.println(findPeakIndexInMountainArray(arr));

    }

    private static int findPeakIndexInMountainArray(int[] arr) {
        int start = 1;
        int end = arr.length - 2;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])
                return mid;

            if(arr[mid-1 ] < arr[mid])
                start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
}
