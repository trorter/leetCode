package example1;

import java.util.ArrayDeque;

/**
 * @author Andrey Ledovskikh
 */
public class Solution695 {

    public static void main(String[] args) {
//        final var grid = new int[][] {
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}
//                };
        final var grid = new int[][] {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        System.out.println(new Solution695().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        final var visited = new boolean[grid.length][grid[0].length];

        var maxSquare = 0;

        for (var y = 0; y < grid.length; y++) {
            for (var x = 0; x < grid[0].length; x++) {
                if (visited[y][x]) {
                    continue;
                }

                if (grid[y][x] == 0) {
                    visited[y][x] = true;
                    continue;
                }

                var curSquare = checkIslandSquare(grid, visited, new Cell1(x, y));

                maxSquare = Math.max(maxSquare, curSquare);
            }
        }

        return maxSquare;
    }

    private final int[][] divs = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    private int checkIslandSquare(int[][] grid, boolean[][] visited, Cell1 cell) {
        var square = 0;

        final var seq = new ArrayDeque<Cell1>();
        seq.add(cell);

        while (!seq.isEmpty()) {

            var curCell = seq.removeFirst();

            if (visited[curCell.y()][curCell.x()]) {
                continue;
            }

            square++;
            visited[curCell.y()][curCell.x()] = true;

            for (var div : this.divs) {
                var nextY = curCell.y() + div[0];
                var nextX = curCell.x() + div[1];

                if (nextY < 0 || nextY == grid.length
                        || nextX < 0 || nextX == grid[0].length
                        || visited[nextY][nextX]) {
                    continue;
                }

                if (grid[nextY][nextX] == 0) {
                    visited[nextY][nextX] = true;
                    continue;
                }

                seq.addLast(new Cell1(nextX, nextY));
            }
        }

        return square;
    }
}

record Cell1(int x, int y) {}
