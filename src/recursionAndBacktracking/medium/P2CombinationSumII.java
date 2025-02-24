package recursionAndBacktracking.medium;

import java.util.*;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class P2CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(arr);
        Set<List<Integer>> ans = new HashSet<>();
        combinationSum2(arr, 0, 8, new LinkedList<>(), ans, -1);
        ans.forEach(System.out::println);
    }


    private static void combinationSum2(int[] arr, int index, int target, List<Integer> comb, Set<List<Integer>> ans, int prev) {
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        if (arr.length == index || target < 0) return;


        if(prev != arr[index]) {
            comb.add(arr[index]);
            // Include Single Time
            combinationSum2(arr, index + 1, target - arr[index], comb, ans, arr[index]);
            comb.removeLast();
        }

        // Exclude
        combinationSum2(arr, index + 1, target, comb, ans, prev);

    }

}
