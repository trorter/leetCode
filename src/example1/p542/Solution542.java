package example1.p542;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Andrey Ledovskikh
 */
public class Solution542 {

    public static void main(String[] args) {
        //[[0,0,0],[0,1,0],[0,0,0]]
//        final var mat = new int[][] {
//                {0,0,0},
//                {0,1,0},
//                {0,0,0}
//        };
        //[[0,0,0],[0,1,0],[1,1,1]]
        final var mat = new int[][] {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };

        System.out.println(Arrays.deepToString(new Solution542().updateMatrix(mat)));
    }

    private final int[][] divs = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    public int[][] updateMatrix(int[][] mat) {
        var result = new int[mat.length][mat[0].length];
        for (var array : result) {
            Arrays.fill(array, -1);
        }

        final var queue = new ArrayDeque<Cell542>();

        for (var x = 0; x < mat.length; x++) {
            for (var y = 0; y < mat[0].length; y++) {
                if (mat[x][y] == 0) {
                    queue.addFirst(new Cell542(x, y));
                    result[x][y] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            affectCells(result, queue, queue.removeLast());
        }

        return result;
    }

    private void affectCells(final int[][] result, final Deque<Cell542> queue, final Cell542 cell) {
        final var isZero = result[cell.x()][cell.y()] == 0;

        for (var div : divs) {
            var nextX = cell.x() + div[0];
            var nextY = cell.y() + div[1];

            if (nextX < 0 || nextX == result.length
                    || nextY < 0 || nextY == result[0].length
                    || result[nextX][nextY] == 0) {
                continue;
            }

            if (isZero) {
                result[nextX][nextY] = 1;
                queue.addFirst(new Cell542(nextX, nextY));
            } else if (result[nextX][nextY] == -1 || (result[cell.x()][cell.y()] + 1) < result[nextX][nextY] ) {
                result[nextX][nextY] = result[cell.x()][cell.y()] + 1;
                queue.addFirst(new Cell542(nextX, nextY));
            }
        }
    }
}

record Cell542 (int x, int y) {}

