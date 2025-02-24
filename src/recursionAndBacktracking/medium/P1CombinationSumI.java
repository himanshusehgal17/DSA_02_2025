package recursionAndBacktracking.medium;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of
 * candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 * of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations
 * for the given input.
 * <p>
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * <p>
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 * <p>
 * Link: https://leetcode.com/problems/combination-sum/submissions/1550422876/
 */
public class P1CombinationSumI {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> ans1 = new ArrayList<>();
        findAllPossibleArray(arr, 0, new ArrayList<>(), 8, ans1);
        ans1.forEach(System.out::println);
        Set<List<Integer>> ans = new HashSet<>();
        ans.stream().toList();
        List<Integer> comb = new ArrayList<>();
        combinationSum(arr, 8, 0, comb, ans);
        ans.forEach(System.out::println);
    }


    public static void combinationSum(int[] arr, int target, int index, List<Integer> comb, Set<List<Integer>> ans) {

        if(arr.length == index || target < 0) {
            return;
        }

        if(target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }


        comb.addLast(arr[index]);
        // Single Inclusion
        combinationSum(arr, target - arr[index], index + 1, comb, ans);

        // Multiple Inclusion
        combinationSum(arr, target - arr[index], index, comb, ans);
        // Exclude
        comb.removeLast();
        combinationSum(arr, target, index + 1, comb, ans);

    }


    private static void findAllPossibleArray(int[] arr, int index, List<Integer> comArr, int target, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(comArr)); // Add a copy of comArr to avoid mutations
            return;
        }
        if (target < 0 || index == arr.length) {
            return;
        }

        // Include current element
        comArr.add(arr[index]);
        findAllPossibleArray(arr, index, comArr, target - arr[index], ans); // Same index for unlimited use
        comArr.remove(comArr.size() - 1); // Backtrack

        // Exclude current element and move to next
        findAllPossibleArray(arr, index + 1, comArr, target, ans);
    }

}
