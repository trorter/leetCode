package example1;

import java.util.*;

/**
 * @author Andrey Ledovskikh
 */
public class Solution1048 {

    public static void main(String[] args) {
        var words = new String[] {"a","b","ba","bca","bda","bdca"};
        System.out.println(new Solution1048().longestStrChain(words));
    }

    private int dfs(Set<String> words, Map<String, Integer> memo, String currentWord) {
        if (memo.containsKey(currentWord)) {
            return memo.get(currentWord);
        }

        var maxLength = 1;

        for (int i = 0; i < currentWord.length(); i++) {
            var newWord = new StringBuilder(currentWord).deleteCharAt(i).toString();

            if (words.contains(newWord)) {
                maxLength = Math.max(maxLength, 1 + dfs(words, memo, newWord));
            }
        }

        memo.put(currentWord, maxLength);
        return maxLength;
    }

    public int longestStrChain(String[] words) {
        var memo = new HashMap<String, Integer>();

        var wordsPresent = new HashSet<String>();
        Collections.addAll(wordsPresent, words);

        var max = 0;
        for (String word : words) {
            max = Math.max(max, dfs(wordsPresent, memo, word));
        }
        return max;
    }
}
