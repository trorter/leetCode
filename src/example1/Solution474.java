package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution474 {

    public static void main(String[] args) {
        //strs = ["10","0001","111001","1","0"], m = 5, n = 3
        var strs = new String[] {"10","0001","111001","1","0"};
        var m = 5;
        var n = 3;
        System.out.println(new Solution474().findMaxForm(strs, m, n));
    }

    record Pair(int zCount, int oCount) {}

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] memo = new int[strs.length][m + 1][n + 1];
        return calculate(strs, 0, m, n, memo);
    }
    public int calculate(String[] strs, int i, int zeroes, int ones, int[][][] memo) {
        if (i == strs.length) {
            return 0;
        }

        if (memo[i][zeroes][ones] != 0) {
            return memo[i][zeroes][ones];
        }

        var count = count(strs[i]);

        var taken = -1;
        if (zeroes - count.zCount >= 0 && ones - count.oCount >= 0) {
            taken = calculate(strs, i + 1, zeroes - count.zCount, ones - count.oCount, memo) + 1;
        }
        var not_taken = calculate(strs, i + 1, zeroes, ones, memo);

        memo[i][zeroes][ones] = Math.max(taken, not_taken);

        return memo[i][zeroes][ones];
    }

    public Pair count(String s) {
        var zCount = 0;
        var oCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zCount++;
            } else {
                oCount++;
            }
        }
        return new Pair(zCount, oCount);
    }
}
