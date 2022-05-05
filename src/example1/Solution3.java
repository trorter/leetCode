package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution3 {

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("aab"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        if (s.isBlank()) {
            return 1;
        }

        var max = -1;


        for (var i = 0; i < s.length(); i++) {
            var chars = new int[128];

            for (var j = i; j < s.length(); j++) {
                var index = (int) s.charAt(j) - 'a';
                chars[index]++;

                if (chars[index] > 1) {
                    max = Math.max(max, j - i);
                    break;
                }

                if (j + 1 == s.length()) {
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }

        return max == -1? s.length() : max;
    }
}
