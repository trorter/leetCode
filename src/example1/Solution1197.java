package example1;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * @author Andrey Ledovskikh
 */
public class Solution1197 {

    public static void main(String[] args) {
        System.out.println(new Solution1197().minKnightMoves(2, 112));
    }

    private final int[][] dirs = new int [][] {
            { 2,  1}, //1
            { 2, -1}, //2
            { 1, -2}, //3
            {-1, -2}, //4
            {-2, -1}, //5
            {-2,  1}, //6
            {-1,  2}, //7
            { 1,  2}  //8
    };

    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }

        record Cell(int x, int y) {}

        var stack = new ArrayDeque<Cell>();
        var memo = new boolean[1_000][1_000];

        stack.push(new Cell(0,0));
        memo[500][500] = true;

        var count = 1;
        while (true) {
            var newStack = new ArrayDeque<Cell>();

            while (!stack.isEmpty()) {
                var cell = stack.pop();

                for (var dir : this.dirs) {
                    var nextX = cell.x + dir[0];
                    var nextY = cell.y + dir[1];

                    if (nextX == x && nextY == y) {
                        return count;
                    }

                    //if already been here
                    if (memo[500 + nextX][500 + nextY]) {
                        continue;
                    }
                    memo[500 + nextX][500 + nextY] = true;

                    //if too far
                    if (Math.abs(nextX - x) > 10 && Math.abs(cell.x - x) < Math.abs(nextX - x) ) {
                        continue;
                    }
                    if (Math.abs(nextY - y) > 10 && Math.abs(cell.y - y) < Math.abs(nextY - y)) {
                        continue;
                    }

                    var nextCell = new Cell(nextX, nextY);
                    newStack.add(nextCell);
                }
            }

            stack = newStack;
            count++;
        }
    }
}
