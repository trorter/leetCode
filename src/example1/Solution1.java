package example1;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;

/**
 * @author Andrey Ledovskikh
 */
public class Solution1 {


    public static void main(String[] args) {
        // [1,2,3]
        // [3,8,4]
        // [5,3,5]
        var grid = new int[][] {
                {1, 2, 3},
                {3, 8, 4},
                {5, 3, 5}
        };
        System.out.println(new Solution1().minimumEffortPath(grid));
    }

    private final int[][] divs = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {

        if (heights.length == 1 && heights[0].length == 1) {
            return 0;
        }

        var minVertex = Integer.MAX_VALUE;
        var maxVertex = Integer.MIN_VALUE;

        for (var row
                : heights) {
            for (var vertex
                    : row) {
                if (minVertex > vertex) {
                    minVertex = vertex;
                }
                if (maxVertex < vertex) {
                    maxVertex = vertex;
                }
            }
        }

        var end = maxVertex - minVertex;
        var start = 0;
        var checkK = 0;

        while(start != end) {
            checkK = (start + end) / 2;
            //if (findPath(heights, checkK, heights[0][0], 0, 0)) {
            if (canReachDestinaton(heights, checkK)) {
                end = checkK;
            } else {
                start = checkK + 1;
            }
        }

        return start;
    }

    boolean canReachDestinaton(int[][] heights, int k) {
        var maxX = heights.length - 1;
        var maxY = heights[0].length - 1;

        var dqueue = new ArrayDeque<SimpleEntry<Integer, Integer>>();
        var visited = new boolean[maxX + 1][maxY + 1];

        dqueue.addLast(new SimpleEntry<>(0, 0));
        visited[0][0] = true;

        while (!dqueue.isEmpty()) {
            var cell = dqueue.removeFirst();

            if (cell.getKey() == maxX && cell.getValue() == maxY) {
                return true;
            }

            for (int[] xyGap : this.divs) {
                var nextX = cell.getKey() + xyGap[0];
                var nextY = cell.getValue() + xyGap[1];

                if (0 <= nextX && nextX <= maxX
                        && 0 <= nextY && nextY <= maxY
                        && !visited[nextX][nextY]) {
                    if (Math.abs(heights[cell.getKey()][cell.getValue()] - heights[nextX][nextY]) <= k) {
                        dqueue.addLast(new SimpleEntry<>(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        return false;
    }

    private boolean findPath(
            int[][] vertices,
            int threshold,
            int prevVertex,
            int currentX,
            int currentY) {

        if (Math.abs(
                prevVertex
                        - vertices[currentX][currentY])
                > threshold) {
            return false;
        }

        if (currentX == vertices.length - 1 &&
                currentY == vertices[0].length - 1) {
            return true;
        }

        var tmp = vertices[currentX][currentY];
        vertices[currentX][currentY] = -1;

        for (int[] xyGap : this.divs) {
            var nextX = currentX + xyGap[0];
            var nextY = currentY + xyGap[1];

            if (0 <= nextX && nextX < vertices.length
                    && 0 <= nextY && nextY < vertices[0].length
                    && vertices[nextX][nextY] != -1) {
                if (findPath(vertices, threshold, tmp, nextX, nextY)) {
                    vertices[currentX][currentY] = tmp;
                    return true;
                }
            }
        }

        vertices[currentX][currentY] = tmp;
        return false;
    }


//    private boolean checkThreshold(
//            int[][] heights,
//            int currentK) {
//
//        var check = false;
//
//        if (heights[0].length > 1) {
//            var tmp = heights[0][0];
//            heights[0][0] = -1;
//
//            check = findPath(heights, currentK, tmp, 0, 1);
//
//            heights[0][0] = tmp;
//        }
//        if (!check
//                && heights.length > 1) {
//            var tmp = heights[0][0];
//            heights[0][0] = -1;
//
//            check = findPath(heights, currentK, tmp, 1, 0);
//
//            heights[0][0] = tmp;
//        }
//
//        return check;
//    }
//
//    private boolean findPath(
//            int[][] vertices,
//            int threshold,
//            int prevVertex,
//            int nextX,
//            int nextY) {
//        if (Math.abs(
//                prevVertex
//                        - vertices[nextX][nextY])
//                > threshold) {
//            return false;
//        }
//
//        if (nextX == vertices.length - 1 &&
//                nextY == vertices[0].length - 1) {
//            return true;
//        }
//
//        var tmp = vertices[nextX][nextY];
//        vertices[nextX][nextY] = -1;
//
//        for (int[] xyGap : new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
//            var nextNextX = nextX + xyGap[0];
//            var nextNextY = nextY + xyGap[1];
//
//            if (0 <= nextNextX && nextNextX < vertices.length
//                    && 0 <= nextNextY && nextNextY < vertices[0].length
//                    && vertices[nextNextX][nextNextY] != -1) {
//                if (findPath(vertices, threshold, tmp, nextNextX, nextNextY)) {
//                    vertices[nextX][nextY] = tmp;
//                    return true;
//                }
//            }
//        }
//
//        vertices[nextX][nextY] = tmp;
//        return false;
//    }


}
