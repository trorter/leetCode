package example1;

import java.util.Arrays;
import java.util.List;

/**
 * @author Andrey Ledovskikh
 */
public class Solution120 {

    public static void main(String[] args) {
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
//        var triangle = List.of(
//                List.of(2),
//                List.of(3, 4),
//                List.of(6, 5, 7),
//                List.of(4, 1, 8, 3)
//        );
        //[[-1],[2,3],[1,-1,-3]]
        var triangle = List.of(
                List.of(-1),
                List.of(2, 3),
                List.of(1, -1, -3)
        );
        System.out.println(new Solution120().minimumTotal(triangle));
    }
    private int minSum = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        var memo = new int[201][201];
        for (var memoRow : memo) {
            Arrays.fill(memoRow, Integer.MAX_VALUE);
        }
        helper(triangle, memo, 0, 0, 0);
        return this.minSum;
    }

    private void helper(List<List<Integer>> triangle, int[][] memo, int sum, int layer, int index) {
        //if final layer
        if (triangle.size() - 1 == layer) {
            minSum = Math.min(minSum, triangle.get(layer).get(index) + sum);
            return;
        }

        if (memo[layer][index] <= triangle.get(layer).get(index) + sum) {
            return;
        }

        memo[layer][index] = triangle.get(layer).get(index) + sum;

        helper(triangle, memo, memo[layer][index], layer + 1, index);
        if (index <= layer) {
            helper(triangle, memo, memo[layer][index], layer + 1, index + 1);
        }
    }
}
