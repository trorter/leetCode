package example1;

import java.util.Arrays;

/**
 * @author Andrey Ledovskikh
 */
public class Solution867 {

    public static void main(String[] args) {
        //[[1,2,3],[4,5,6],[7,8,9]]
//        var test  = new int [][] {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };

        //[[1,2,3],[4,5,6]]
        var test  = new int [][] {
                {1,2,3},
                {4,5,6}
        };
        var results = new Solution867().transpose(test);
        for (var result : results) {
            System.out.println(Arrays.toString(result));
        }
    }

    public int[][] transpose(int[][] matrix) {
        var result = new int [matrix[0].length][matrix.length];

        for (var x = 0; x < matrix.length; x++) {
            for (var y = 0; y < matrix[0].length; y++) {
                result[y][x] = matrix[x][y];
            }
        }

        return result;
    }
}
