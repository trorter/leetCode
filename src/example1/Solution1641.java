package example1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Andrey Ledovskikh
 */
public class Solution1641 {

    public static void main(String[] args) {
        System.out.println(new Solution1641().countVowelStrings(30));
    }

    public int countVowelStrings(int n) {
        return countVowels(n, 1);
    }

    int countVowels(int n, int passed) {
        if (n == 0) {
            return 1;
        }

        var result = 0;
        for (var i = passed; i <= 5; i++) {
            result += countVowels(n - 1, i);
        }

        return result;
    }

    private final List<String> letters = List.of("a","e","i","o","u");

    public int countVowelStringsBad(int n) {
        if (n == 1) {
            return 5;
        }

        var resultSet = new HashSet<>(letters);

        for (var i = 2; i <= n; i++) {
            final var next = new HashSet<String>();

            for (String val : resultSet) {
                for (var letter : letters) {
                    next.add(val + letter);
                }
            }

            resultSet = next;
        }

        return resultSet.size();
    }

}
