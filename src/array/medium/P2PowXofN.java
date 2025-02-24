package array.medium;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * <p>
 * Example 1:
 * <p>
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * <p>
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * <p>
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class P2PowXofN {
    public static void main(String[] args) {
        System.out.println(myPow(2, -2147483648));
    }

    public static double myPow(double x, int n) {

        if (x == 0) return 0;
        if (x == 1 && n > 0) return 1;
        if (x == 1 && n < 0 && ((-n) & 1) == 1) return -1;
        if (n == 0) return 1;
        long binForm = n;
        if (n < 0) {
            x = 1 / x;
            binForm = -binForm;
        }


        double ans = 1;
        while (binForm > 0) {
            if ((binForm & 1) == 1)
                ans *= x;
            ans *= ans;
            binForm = binForm >> 1;
        }

        return ans;

    }

}
