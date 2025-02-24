package strings.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class P2LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
        ;
    }

    public static String longestCommonPrefix(String[] strs) {

        Optional<Integer> minLength = Arrays.stream(strs).map(String::length).min(Comparator.comparingInt(a -> a));
        int min = minLength.orElse(0);
        int startPointer = 0;
        String ans = "";
        while (startPointer < min) {
            char ch = 0;
            for (int i = 0; i < strs.length - 1; i++) {
                ch = strs[i].charAt(startPointer);
                if (strs[i].charAt(startPointer) != strs[i + 1].charAt(startPointer)) {
                    return ans;
                }
            }
            if (ch != 0)
                ans = ans + ch;
            startPointer++;
        }

        return ans;
    }
}
