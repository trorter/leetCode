package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution1209 {

    public static void main(String[] args) {
        System.out.println(new Solution1209().removeDuplicates("deeedbbcccbdaa" , 3));
    }

    public String removeDuplicates(String s, int k) {
        final var result = new StringBuilder(s);
        final var count = new int[result.length()];

        for (var i = 0; i < result.length(); i++) {
            if (i == 0 || result.charAt(i) != result.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;

                if (count[i] == k) {
                    result.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }

        return result.toString();
     }

}
