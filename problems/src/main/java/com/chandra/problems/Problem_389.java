package com.chandra.problems;

/**
 * 389. Find the Difference
 *
 * Given two strings s and t which consist of only lowercase letters.

 String t is generated by random shuffling string s and then add one more letter at a random position.

 Find the letter that was added in t.

 Example:

 Input:
 s = "abcd"
 t = "abcde"

 Output:
 e

 Explanation:
 'e' is the letter that was added.
 */
public class Problem_389 {
    public static class Solution_1 {
        public char findTheDifference(String s, String t) {
            int res = 0;
            for (int i=0;i<t.length();i++) res += t.charAt(i);
            for (int i=0;i<s.length();i++) res -= s.charAt(i);
            return (char)res;
        }
    }

    public static class Solution_2 {
        public char findTheDifference(String s, String t) {
            char c = 0;
            for (char ch : s.toCharArray()) c ^= ch;
            for (char ch : t.toCharArray()) c ^= ch;

            return c;
        }
    }
}