package example1;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author Andrey Ledovskikh
 */
public class Solution733 {

    public static void main(String[] args) {
        //[[0,0,0],[0,1,1]]
        //1
        //1
        //1
        var image = new int [][] {
                {0, 0, 0},
                {0, 1, 1}
        };
        var sr = 1;
        var sc = 1;
        var newColor = 1;
        System.out.println(Arrays.deepToString(new Solution733().floodFill(image, sr, sc, newColor)));
    }

    private final int[][] divs = new int [][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        final var oldColor = image[sr][sc];

        if (oldColor == newColor) {
            return image;
        }

        final var stack = new ArrayDeque<int[]>();
        stack.addFirst(new int[] {sr, sc});

        while (!stack.isEmpty()) {
            var cell = stack.removeFirst();

            if (image[cell[0]][cell[1]] == oldColor) {
                image[cell[0]][cell[1]] = newColor;

                for (var div : divs) {
                    var nextX = cell[0] + div[0];
                    var nextY = cell[1] + div[1];
                    if ((nextX >= 0 && nextX < image.length) && (nextY >= 0 && nextY < image[0].length)) {
                        stack.addFirst(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return image;
    }

}
