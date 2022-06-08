package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution1332 {

    public static void main(String[] args) {
        var s = "ababb";
        System.out.println(new Solution1332().removePalindromeSub(s));
    }

    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        var start = 0;
        var end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return 2;
            }
            start++;
            end--;
        }

        return 1;
    }
}
