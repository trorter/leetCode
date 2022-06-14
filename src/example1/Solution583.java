package example1;

import java.util.Optional;

/**
 * @author Andrey Ledovskikh
 */
public class Solution583 {

    public static void main(String[] args) {
        //"park"
        //"spake"
        var word1 = "park";
        var word2 = "spake";
        System.out.println(new Solution583().minDistance(word1, word2));
    }

    public int minDistance(String s1, String s2) {
        return s1.length() + s2.length() - 2 *
                lcs(s1, s2, new int[s1.length()][s2.length()], s1.length() - 1, s2.length() - 1);
    }

    public int lcs(String s1, String s2, int[][] memo, int s1Index, int s2Index) {
        if (s1Index < 0 || s2Index < 0) {
            return 0;
        }

        if (memo[s1Index][s2Index] > 0) {
            return memo[s1Index][s2Index];
        }

        if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
            memo[s1Index][s2Index] = 1 + lcs(s1, s2, memo, s1Index - 1, s2Index - 1);
        } else {
            memo[s1Index][s2Index] = Math.max(
                    lcs(s1, s2, memo, s1Index, s2Index - 1),
                    lcs(s1, s2, memo, s1Index - 1, s2Index));
        }
        return memo[s1Index][s2Index];
    }
}
