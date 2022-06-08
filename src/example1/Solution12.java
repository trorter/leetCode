package example1;

import java.util.Map;

/**
 * @author Andrey Ledovskikh
 */
public class Solution12 {

    public static void main(String[] args) {
        var num = 1994;
        System.out.println(new Solution12().intToRoman(num));
    }

    private final Map<Integer, String> romansDigits = Map.of(
            1, "I",
            5, "V",
            10, "X",
            50, "L",
            100, "C",
            500, "D",
            1_000, "M"
    );

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        var position = -1;
        while (num > 0) {
            var curNum = num % 10;

            num /= 10;
            position++;

            if (curNum < 4) {
                for (var i = 1; i <= curNum; i++) {
                    result.insert(0, romansDigits.get((int) Math.pow(10, position)));
                }
                continue;
            }

            if (curNum == 4) {
                result.insert(0, romansDigits.get(5 * (int) Math.pow(10, position)));
                result.insert(0, romansDigits.get((int) Math.pow(10, position)));
                continue;
            }

            if (curNum == 5) {
                result.insert(0, romansDigits.get(5 * (int) Math.pow( 10, position)));
                continue;
            }

            if (curNum < 9) {
                for (var i = 6; i <= curNum; i++) {
                    result.insert(0, romansDigits.get((int) Math.pow(10, position)));
                }
                result.insert(0, romansDigits.get(5 * (int) Math.pow(10, position)));
                continue;
            }

            result.insert(0, romansDigits.get((int) Math.pow(10, position + 1)));
            result.insert(0, romansDigits.get((int) Math.pow(10, position)));
        }

        return result.toString();
    }
}
