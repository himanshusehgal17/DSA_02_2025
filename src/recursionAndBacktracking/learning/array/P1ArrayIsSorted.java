package recursionAndBacktracking.learning.array;

public class P1ArrayIsSorted {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 12, 9};
        System.out.println(isSorted(arr, 0));

    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    private static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) return true;
        return arr[i] < arr[i + 1] && isSorted(arr, i + 1);
    }
}
