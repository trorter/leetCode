package example1;

import org.w3c.dom.Node;

import java.util.*;

/**
 * @author Andrey Ledovskikh
 */
public class Solution399 {

    public static void main(String[] args) {
        //[["a","b"],["b","c"]]
        //[2.0,3.0]
        //[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//        var equations = List.of(
//                List.of(
//                       "a",
//                       "b"
//                ),
//                List.of(
//                        "b",
//                        "c"
//                )
//        );
//        var values = new double[] {2D, 3D};
//        var queries = List.of(
//                List.of(
//                        "a",
//                        "c"
//                ),
//                List.of(
//                        "b",
//                        "a"
//                ),
//                List.of(
//                        "a",
//                        "e"
//                ),
//                List.of(
//                        "a",
//                        "a"
//                ),
//                List.of(
//                        "x",
//                        "x"
//                )
//        );

        //[["a","b"],["b","c"],["bc","cd"]]
        //[1.5,2.5,5.0]
        //[["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//        var equations = List.of(
//                List.of(
//                        "a",
//                        "b"
//                ),
//                List.of(
//                        "b",
//                        "c"
//                ),
//                List.of(
//                        "bc",
//                        "cd"
//                )
//        );
//        var values = new double[] {1.5D, 2.5D, 5D};
//        var queries = List.of(
//                List.of(
//                        "a",
//                        "c"
//                ),
//                List.of(
//                        "c",
//                        "b"
//                ),
//                List.of(
//                        "bc",
//                        "cd"
//                ),
//                List.of(
//                        "cd",
//                        "bc"
//                ),
//                List.of(
//                        "x",
//                        "x"
//                )
//        );
        //[["a","e"],["b","e"]]
        //[4.0,3.0]
        //[["a","b"],["e","e"],["x","x"]]
        var equations = List.of(
                List.of(
                        "a",
                        "e"
                ),
                List.of(
                        "b",
                        "e"
                )
        );
        var values = new double[]{4D, 3D};
        var queries = List.of(
                List.of(
                        "a",
                        "b"
                ),
                List.of(
                        "e",
                        "e"
                ),
                List.of(
                        "x",
                        "x"
                ),
                List.of(
                        "cd",
                        "bc"
                ),
                List.of(
                        "x",
                        "x"
                )
        );
        new Solution399().calcEquation(equations, values, queries);
    }

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        final var graph = new HashMap<String, Map<String, Double>>();
        final var graphSize = equations.size();

        // Step 1). build the graph from the equations
        for (var i = 0;
             i < graphSize;
             i++) {
            
            final var dividend = equations.get(i).get(0);
            final var divisor = equations.get(i).get(1);

            graph.putIfAbsent(
                    dividend,
                    new HashMap<>());

            graph.putIfAbsent(
                    divisor,
                    new HashMap<>());

            graph.get(dividend)
                    .put(
                        divisor,
                        values[i]);
            graph.get(divisor)
                    .put(
                        dividend,
                        Math.pow(values[i], -1));
        }

        final var result = new double[queries.size()];

        for (var i = 0;
             i < queries.size();
             i++) {

            final var dividend = queries.get(i).get(0);
            final var divisor = queries.get(i).get(1);

            if (!graph.containsKey(dividend)
                    || !graph.containsKey(divisor)) {
                result[i] = -1D;
                continue;
            }

            if (Objects.equals(dividend, divisor)) {
                result[i] = 1D;
                continue;
            }

            final var visited = new HashSet<String>();
            result[i] = backtrackFindPath(
                    graph,
                    visited,
                    dividend,
                    divisor,
                    1
            );
        }

        return result;
    }

    private double backtrackFindPath(
            Map<String, Map<String, Double>> graph,
            Set<String> visited,
            String curNode,
            String endNode,
            double curResult) {

        visited.add(curNode);
        var foundResult = -1D;

        final var linkedNodes = graph.get(curNode);
        if (linkedNodes.containsKey(endNode)) {
            return curResult * linkedNodes.get(endNode);
        }

        for (var entrySet
                : linkedNodes.entrySet()) {

            if (visited.contains(entrySet.getKey())) {
                continue;
            }

            foundResult = backtrackFindPath(
                    graph,
                    visited,
                    entrySet.getKey(),
                    endNode,
                    curResult * entrySet.getValue()
            );

            if (foundResult != -1) {
                break;
            }
        }

        visited.remove(curNode);

        return foundResult;
    }
}
//    record Cell(int x, int y, double multiplayer) {}
//    private int[][] divsAndRoute = new int[][] {
//            {1, 0, 1},
//            {0, 1, 1},
//            {-1, 0, -1},
//            {0, -1, -1}
//    };
//
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        final var vertices = equations
//                .stream()
//                .flatMap(Collection::stream)
//                .distinct()
//                .sorted((var a, var b) -> {
//                    if (a.length() == b.length()) {
//                        return  a.compareTo(b);
//                    }
//                    return a.length() < b.length()? -1 : 1;
//                })
//                .toList();
//        final var verticesCount = vertices.size();
//
//        final var vWeighs = new double[verticesCount][verticesCount];
//        final var result = new double[queries.size()];
//
//        for (var i = 0; i < queries.size(); i++) {
//            if (!vertices.containsAll(queries.get(i))) {
//                result[i] = -1D;
//                continue;
//            }
//
//            resetVWeigh(vWeighs, vertices, verticesCount, equations, values);
//
//            final var visited = new boolean[verticesCount][verticesCount];
//            final var startX = vertices.indexOf(queries.get(i).get(0));
//            final var endY = vertices.indexOf(queries.get(i).get(1));
//
//            var curResult = findPath(
//                    vWeighs,
//                    visited,
//                    endY,
//                    new Cell(
//                            startX,
//                            startX,
//                            1),
//                    verticesCount);
//            result[i] = curResult;
//        }
//
//        return result;
//    }
//
//    private double findPath(double[][] vWeighs, boolean[][] visited, int endY, Cell vertex, int verticesCount) {
//        if (vertex.y == endY) {
//            return vertex.multiplayer;
//        }
//
//        visited[vertex.x][vertex.y] = true;
//
//        for (var div
//                : divsAndRoute) {
//
//            final var nextX = vertex.x + div[0];
//            final var nextY = vertex.y + div[1];
//
//            if (nextX < 0 || nextX >= verticesCount
//                    || nextY < 0 || nextY >= verticesCount
//                    || visited[nextX][nextY]
//                    || vWeighs[nextX][nextY] < 0) {
//                continue;
//            }
//
//            final var nextCell = new Cell(
//                    nextX,
//                    nextY,
//                    Math.pow(
//                            vWeighs[nextX][nextY],
//                            div[2]));
//            final var result = findPath(vWeighs, visited, endY, nextCell, verticesCount);
//            if (result > 0) {
//                return vertex.multiplayer * result;
//            }
//        }
//
//        visited[vertex.x][vertex.y] = false;
//        return -1;
//    }
//
//    private void resetVWeigh(double[][] vWeighs, List<String> vertices, int verticesCount, List<List<String>> equations, double[] values) {
//        //reset to -1 all weighs
//        for (var vWeigh
//             : vWeighs) {
//            Arrays.fill(vWeigh, -1);
//        }
//
//        for (var i = 0; i < values.length; i++) {
//            final var equation = equations.get(i);
//
////            var direction = 1;
////            if (equation.get(0).length() == equation.get(1).length()) {
////                direction = equation.get(0).compareTo(equation.get(1)) < 0 ? 1 : -1;
////            } else {
////                direction = equation.get(0).length() < equation.get(1).length()? 1 : -1;
////            }
//
//            vWeighs[vertices.indexOf(equation.get(0))][vertices.indexOf(equation.get(1))] = values[i];
//            vWeighs[verticesCount - 1 - vertices.indexOf(equation.get(1))][verticesCount - 1 - vertices.indexOf(equation.get(0))] = Math.pow(values[i], -1);
//        }
//
//        for (var i = 0; i < vWeighs.length; i++) {
//            vWeighs[i][i] = 1;
//        }
//
//    }
//}

