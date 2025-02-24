package recursionAndBacktracking.learning.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P2LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 18, 9, 1};
        findAllIndex(arr, 0, 1);
        String collect = findAllIndex(arr,0,1).stream().map(String::valueOf).collect(Collectors.joining(",", "(", ")"));

        System.out.println(collect);
    }

    static int linearSearch(int[] arr, int index, int target) {
        if (index == arr.length) return -1;
        if (arr[index] == target) return index;
        return linearSearch(arr, index + 1, target);
    }

    static int linearSearchReverse(int[] arr, int index, int target) {
        if (index == -1) return -1;
        if (arr[index] == target) return index;
        return linearSearchReverse(arr, index - 1, target);
    }


    static List<Integer> findAllIndex(int[] arr, int index, int target) {
        if (index == arr.length) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        if (arr[index] == target) {
            list.add(index);
        }
        List<Integer> ans = findAllIndex(arr, index + 1, target);
        ans.addAll(list);
        return ans;

    }
}
