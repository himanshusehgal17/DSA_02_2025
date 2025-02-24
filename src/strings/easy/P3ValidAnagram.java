package strings.easy;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given two strings s and t, return true if t is an
 * of s, and false otherwise.
 * <p>
 * <p>
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class P3ValidAnagram {
    public static void main(String[] args) {
        String s = "aa", t = "bb";
        System.out.println(isAnagram(s, t));

    }

    public static boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];

        s.chars().boxed().forEach(c -> alphabets[c - 'a']++);

        t.chars().boxed().forEach(c -> alphabets[c - 'a'] = alphabets[c - 'a'] > 0 ? alphabets[c - 'a']-1: alphabets[c - 'a']);

        return 0 == Arrays.stream(alphabets).boxed().mapToInt(x -> x).sum();

    }
}
