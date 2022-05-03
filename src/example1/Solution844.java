package example1;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author Andrey Ledovskikh
 */
public class Solution844 {

    public boolean backspaceCompare(String s, String t) {
        return deletedLettersString(s).equals(deletedLettersString(t));
    }

    private String deletedLettersString(String string) {
        final var sQueue = new ArrayDeque<String>();
        final var sArray = string.split("");

        for (var letter
                : sArray) {
            if (letter.equals("#")) {
                if (sQueue.size() != 0) {
                    sQueue.removeFirst();
                }
                continue;
            }

            sQueue.addFirst(letter);
        }

        final var result = new StringBuilder(sQueue.size());
        sQueue.forEach(result::append);

        return result.toString();
    }
}
