package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution5 {

    public static void main(String[] args) {
        var s = "bb";
        System.out.println(new Solution5().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        var maxPalindrome = s.substring(0, 1);
        for (var i = 0; i < s.length() - 1; i++) {
            if ((i + 1) < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                var newP = cutPalindrome(s, i, i+1);
                maxPalindrome = newP.length() > maxPalindrome.length() ? newP : maxPalindrome;
            }

            if ((i + 2) < s.length() && s.charAt(i) == s.charAt(i + 2)) {
                var newP = cutPalindrome(s, i, i+2);
                maxPalindrome = newP.length() > maxPalindrome.length() ? newP : maxPalindrome;
            }
        }

        return maxPalindrome;
    }

    private String cutPalindrome(String s, int start, int end) {
        while (0 <= start && end < s.length() && s.charAt(start) == s.charAt(end) ) {
            start--;
            end++;
        }

        return s.substring(++start, end);
    }
}
