package example1;

import java.util.*;

/**
 * @author Andrey Ledovskikh
 */
public class Solution743 {

    public static void main(String[] args) {
        //[[2,1,1],[2,3,1],[3,4,1]]
        //4
        //2
        final var graph = new int[][] {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };
        final var n = 4;
        final var k = 2;
        //[[1,2,1]]
        //2
        //2
//        final var graph = new int[][] {
//                {1,2,1}
//        };
//        final var n = 2;
//        final var k = 2;
        System.out.println(new Solution743().networkDelayTime(graph, n, k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        if (n == 1) {
            return 0;
        }

        record Route (Integer top, Integer time) {}
        
        final var graph = new HashMap<Integer, List<Route>>(n*n);
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new Route(time[1], time[2]));
        }

        final var routeTimes = new int[n+1];
        Arrays.fill(routeTimes, Integer.MAX_VALUE);

        final var stack = new PriorityQueue<Route>(graph.size() * graph.size(), Comparator.comparing(Route::top));
        stack.add(new Route(k, 0));

        while (!stack.isEmpty()) {
            final var next = stack.poll();

            if (routeTimes[next.top] < next.time ) {
                continue;
            }

            routeTimes[next.top] = next.time;

            if (!graph.containsKey(next.top)) {
                continue;
            }

            for (var route : graph.get(next.top)) {
                final var nextRouteTime = route.time + next.time;
                if (routeTimes[route.top] < nextRouteTime ) {
                    continue;
                }
                stack.add(new Route(route.top, nextRouteTime));
            }
        }
        
        
        var max = 0;
        for (var index = 1; index <= n; index++) {
            max = Math.max(max, routeTimes[index]);
        }
        return max == Integer.MAX_VALUE ? -1: max;
    }

//    private void goThrough(Route nextStep, int spendTime) {
//        final var curTime = spendTime + nextStep.time;
//
//        if (routes[nextStep.top] != 0 && routes[nextStep.top] <= curTime) {
//            return;
//        } else {
//            routes[nextStep.top] = curTime;
//        }
//
//        if (graph.containsKey(nextStep.top)) {
//            graph.get(nextStep.top).forEach(route -> goThrough(route, curTime));
//        }
//    }
}
