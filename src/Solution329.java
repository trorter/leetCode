
/**
 * @author Andrey Ledovskikh
 */
public class Solution329 {

    public static void main(String[] args) {
        //[[9,9,4],[6,6,8],[2,1,1]]
        var matrix = new int[][] {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        //[[3,4,5],[3,2,6],[2,2,1]]
//        var matrix = new int[][] {
//                {3,4,5},
//                {3,2,6},
//                {2,2,1}
//        };
        System.out.println(new Solution329().longestIncreasingPath(matrix));
    }

    private final int[][] dirs = {
            { 1,  0},
            { 0,  1},
            {-1,  0},
            { 0, -1}
    };
    private final int[][] memo = new int[200][200];
    private int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        this.matrix = matrix;
        
        var result = 0;
        for (var x = 0; x < matrix.length; x++) {
            for (var y = 0; y < matrix[0].length; y++) {
                result = Math.max(result, dfs(x, y));
            }
        }

        return result;
    }

    private int dfs(int x, int y) {
        if (this.memo[x][y] != 0) {
            return this.memo[x][y];
        }

        for (var dir : this.dirs) {
            var nextX = x + dir[0];
            var nextY = y + dir[1];

            if (0 <= nextX && nextX < this.matrix.length
                    && 0 <= nextY && nextY < this.matrix[0].length
                    && this.matrix[x][y] < this.matrix[nextX][nextY]) {
                this.memo[x][y] = Math.max(this.memo[x][y], dfs(nextX, nextY));
            }
        }
        return this.memo[x][y] += 1;
    }
}
