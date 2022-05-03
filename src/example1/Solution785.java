package example1;

import java.util.ArrayDeque;

/**
 * @author Andrey Ledovskikh
 */
public class Solution785 {

    public static void main(String[] args) {
        //[[1,3],[0,2],[1,3],[0,2]]
//        var graph = new int[][] {
//                {1, 3},
//                {0, 2},
//                {1, 3},
//                {0, 2}
//        };

        //[[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]
//        var graph = new int[][] {
//                {},
//                {2, 4, },
//                {1, 4, 8, 9}
//        };
        //[[4],[],[4],[4],[0,2,3]]
        var graph = new int[][] {
                {4},
                {},
                {4},
                {4},
                {0, 2, 3}
        };
        System.out.println(new Solution785().isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {
        final var vorticesCount = graph.length;
        final var vorticesColor = new int[vorticesCount];

        while (findNextBlank(vorticesColor) != -1) {
            var nextVertex = findNextBlank(vorticesColor);
            if (!checkPartOfGraph(graph, vorticesColor, nextVertex)) {
                return false;
            }
        }

        return true;
    }

    boolean checkPartOfGraph(int[][] graph, int[]vorticesColor, int startVertex) {
        final var stack = new ArrayDeque<Cell>();
        stack.addLast(new Cell(startVertex, 1));
        vorticesColor[startVertex] = 1;

        while(!stack.isEmpty()) {
            var currentVortex = stack.removeFirst();

            var nextSteps = graph[currentVortex.vortexIndex];

            for (var nextStep
                    : nextSteps) {

                final var oppositeColor = currentVortex.getOppositeColor();

                if (vorticesColor[nextStep] == 0) {
                    stack.addLast(new Cell(nextStep, oppositeColor));
                    vorticesColor[nextStep] = oppositeColor;
                    continue;
                }

                if (vorticesColor[nextStep] != oppositeColor) {
                    return false;
                }
            }
        }
        return true;
    }

    int findNextBlank(int[] colors) {
        for(var i = 0; i < colors.length; i++) {
            if (colors[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}

class Cell {
    /**
     * 0 - blank
     * 1 - blue
     * 2 - red
     */
    final int color;
    final int vortexIndex;

    public Cell(int vortexIndex, int color) {
        this.color = color;
        this.vortexIndex = vortexIndex;
    }

    int getOppositeColor() {
        return color == 1? 2 : 1;
    }
}
