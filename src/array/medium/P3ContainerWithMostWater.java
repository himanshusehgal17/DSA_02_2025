package array.medium;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 */

public class P3ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1, 1};

        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] arr) {

        int leftPointer = 0;
        int rightPointer = arr.length - 1;

        int maxArea = Integer.MIN_VALUE;
        while (leftPointer < rightPointer) {
            int width = rightPointer - leftPointer;
            int height = Math.min(arr[rightPointer], arr[leftPointer]);
            int currentArea = width * height;
            maxArea = Math.max(currentArea, maxArea);

            if (arr[leftPointer] < arr[rightPointer]) {
                leftPointer++;
            } else rightPointer--;

        }

        return maxArea;
    }
}
