package recursionAndBacktracking.learning.array;

public class P3RBS {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 9, 1, 2, 3};

        System.out.println(rbs(arr, 0, arr.length - 1, 5));
        System.out.println(rbs(arr, 0, arr.length - 1, 6));
        System.out.println(rbs(arr, 0, arr.length - 1, 3));
        System.out.println(rbs(arr, 0, arr.length - 1, 1));
        System.out.println(rbs(arr, 0, arr.length - 1, 112));
    }

    public static int rbs(int[] arr, int start, int end, int target) {
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] > arr[start] && arr[start] <= target && arr[mid] > target) {
            return rbs(arr, start, mid, target);
        } else {
            return rbs(arr, mid + 1, end, target);
        }

    }
}
