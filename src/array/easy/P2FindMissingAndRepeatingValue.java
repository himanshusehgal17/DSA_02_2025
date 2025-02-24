package array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2].
 * Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.
 * Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[1,3],[2,2]]
 * Output: [2,4]
 * Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
 * Output: [9,5]
 * Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].
 */
public class P2FindMissingAndRepeatingValue {

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 2}};

        Arrays.stream(findMissingAndRepeatedValuesSpaceOptimized(arr)).boxed().forEach(System.out::println);

    }

    public static int[] findMissingAndRepeatedValuesSpaceOptimized(int[][] grid) {
        int n = grid.length * grid.length;

        int actualSum = n * (n + 1) / 2;
        int actualSquareSum = n * (n + 1) * (2 * n + 1) / 6;

        int currentSum = 0;
        int currentSquareSum = 0;

        for (int[] ints : grid) {
            for (int item : ints) {
                currentSum += item;
                currentSquareSum += (item * item);
            }
        }

        /**
         * missing - repeating = actual - currentSum
         * missing + repeating = (squareActual - squareCurrent) / diff
         */

        int diff = actualSum - currentSum;
        int squareDiff = (actualSquareSum - currentSquareSum) / diff;

        int missing = (diff + squareDiff) / 2;
        int repeating = currentSum + missing - actualSum;

        return new int[]{repeating, missing};

    }

    // Time O (n2) Space O(n)
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length * grid.length;
        int actualSum = n * (n + 1) / 2;
        int currentSum = 0;
        int repeatingNum = -1;
        Set<Integer> checkRepeatingInt = new HashSet<>();
        for (int[] ints : grid) {
            for (int currentItem : ints) {
                if (!checkRepeatingInt.add(currentItem)) {
                    repeatingNum = currentItem;
                }
                currentSum += currentItem;

            }
        }

        int missingNum = actualSum - currentSum + repeatingNum;

        return new int[]{repeatingNum, missingNum};
    }
}
