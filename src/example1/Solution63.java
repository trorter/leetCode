package example1;

import java.util.Arrays;

/**
 * @author Andrey Ledovskikh
 */
public class Solution63 {

    public static void main(String[] args) {
        //[[0,0,0],[0,1,0],[0,0,0]]
//        var matrix = new int[][] {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };

        //[[0,1],[0,0]]
        var matrix = new int[][] {
                {0, 1},
                {0, 0}
        };

        //[[0,0,0,0],[0,1,0,0],[0,0,0,0],[0,0,1,0],[0,0,0,0]]
//        var matrix = new int[][] {
//                {0, 0, 0, 0},
//                {0, 1, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 1, 0},
//                {0, 0, 0, 0}
//        };
        //[[0,0,0,0,0],[0,0,0,0,1],[0,0,0,1,0],[0,0,0,0,0]]
//        var matrix = new int[][] {
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1},
//                {0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 0}
//        };
        //[[0,1,0,0,0],[1,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]
//        var matrix = new int[][] {
//                {0, 1, 0, 0, 0},
//                {1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0}
//        };

        System.out.println(new Solution63().uniquePathsWithObstacles2(matrix));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        //initial for the first x-row
        var count = 1;
        for (var y = 0; y < obstacleGrid[0].length; y++) {
            if (obstacleGrid[0][y] == 1) {
                count = 0;
            }
            obstacleGrid[0][y] = count;
        }

        //initial for the first x-row
        count = 1;
        for (var x = 1; x < obstacleGrid.length; x++) {
            if (obstacleGrid[x][0] == 1) {
                count = 0;
            }
            obstacleGrid[x][0] = count;
        }

        //goes line by line
        for (var x = 1; x < obstacleGrid.length; x++) {
            for (var y = 1; y < obstacleGrid[0].length; y++) {
                if (obstacleGrid[x][y] == 1) {
                    obstacleGrid[x][y] = 0;
                } else {
                    obstacleGrid[x][y] = obstacleGrid[x - 1][y] + obstacleGrid[x][y - 1];
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }



    private final int[][] memo = new int[100][100];
    private int[][] grid;

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (var list : this.memo) {
            Arrays.fill(list, -1);
        }

        this.grid = obstacleGrid;

        return dfsMemo(0, 0);
    }

    private int dfsMemo(int x, int y) {
        if (x == this.grid.length || y == this.grid[0].length) {
            return 0;
        }

        if (this.grid[x][y] == 1) {
            return 0;
        }

        if (x == this.grid.length - 1 && y == this.grid[0].length - 1){
            return 1;
        }

        if (this.memo[x][y] != -1) {
            return memo[x][y];
        }

        memo[x][y] = dfsMemo(x + 1, y) + dfsMemo(x, y + 1);

        return memo[x][y];
    }

}
