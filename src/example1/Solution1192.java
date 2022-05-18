package example1;

import java.util.*;

/**
 * @author Andrey Ledovskikh
 */
public class Solution1192 {

    public static void main(String[] args) {
        //4
        //[[0,1],[1,2],[2,0],[1,3],[2,4]]
//        var n = 5;
//        var list = List.of(
//                List.of(0, 1),
//                List.of(1, 2),
//                List.of(2, 0),
//                List.of(1, 3),
//                List.of(2, 4)
//        );
        var n = 10;
        var list = List.of(
                List.of(1, 2),
                List.of(2, 4),
                List.of(2, 3),
                List.of(3, 4),
                List.of(4, 6),
                List.of(6, 5),
                List.of(6, 0),
                List.of(6, 9),
                List.of(6, 7),
                List.of(7, 8),
                List.of(8, 9),
                List.of(9, 0)
        );
//        var n = 6;
//        var list = List.of(
//                List.of(0, 1),
//                List.of(0, 2),
//                List.of(1, 2),
//                List.of(2, 3),
//                List.of(3, 4),
//                List.of(3, 5),
//                List.of(4, 5)
//        );
        System.out.println(new Solution1192().criticalConnections(n, list));
    }

    record Connection(int start, int end) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Connection that)) return false;
            return (start == that.start && end == that.end) || (start == that.end && end == that.start);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start + end);
        }
    }

    private final Map<Integer, List<Integer>> graph = new HashMap<>();
    private int[] rank;
    private final HashSet<Connection> connDict = new HashSet<>();

    private void formGraph(int n, List<List<Integer>> connections) {
        this.rank = new int[n];

        for (var connection : connections) {
            var first = connection.get(0);
            var second = connection.get(1);

            this.graph.putIfAbsent(first, new ArrayList<>());
            this.graph.get(first).add(second);

            this.graph.putIfAbsent(second, new ArrayList<>());
            this.graph.get(second).add(first);

            connDict.add(new Connection(first, second));
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        formGraph(n, connections);

        dfs(0, 2);

        return this.connDict.stream().map(tmp -> List.of(tmp.start, tmp.end)).toList();
    }

    private int dfs(int node, int discoveryRank) {
        if (this.rank[node] != 0) {
            return this.rank[node];
        }
        this.rank[node] = discoveryRank;

        var minRank = discoveryRank + 1;

        for (var neighbor : this.graph.get(node)) {

            if (this.rank[neighbor] == discoveryRank - 1) {
                continue;
            }

            // Recurse on the neighbor.
            int recursiveRank = dfs(neighbor, discoveryRank + 1);

            // Step 1, check if this edge needs to be discarded.
            if (recursiveRank <= discoveryRank) {
                this.connDict.remove(new Connection(node, neighbor));
            }

            // Step 2, update the minRank if needed.
            minRank = Math.min(minRank, recursiveRank);
        }

        return minRank;
    }

}
