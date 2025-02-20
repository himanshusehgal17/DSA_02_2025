package strings.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * <p>
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * <p>
 * Example 3:
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 * Link: https://leetcode.com/problems/valid-palindrome/description/
 */
public class P1ValidPalindrome {

    public static void main(String[] args) {
        String s = "$$";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String str) {
        char[] arr = str.toLowerCase().toCharArray();
        int start = 0, end = arr.length - 1;
        while (start < end) {

            if ( !isAlphaNumeric(arr[start])) {start++; continue;}
            if (!isAlphaNumeric(arr[end])) {end--; continue;};

            if (arr[start] == arr[end]) {
                start++;
                end--;
            } else return false;

        }

        return true;
    }

    private static boolean isAlphaNumeric(Character c) {
        String alphaNumericReg = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(alphaNumericReg);
        Matcher matcher = pattern.matcher(c+"");
        return matcher.matches();
    }
}
