package example1;

import java.util.Arrays;

/**
 * @author Andrey Ledovskikh
 */
public class Solution567 {

    public static void main(String[] args) {
        System.out.println(new Solution567().checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        s1 = sort(s1);

        final var s1Length = s1.length();
        final var s2Length = s2.length();

        for (var i = 0; i <= s2Length - s1Length; i++) {
            var comparableSortStr = sort(s2.substring(i, i + s1Length));
            if (s1.equals(comparableSortStr)) {
                return true;
            }
        }

        return false;
    }

    private String sort(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}
