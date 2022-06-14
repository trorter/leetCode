package example1;

import java.util.HashMap;

/**
 * @author Andrey Ledovskikh
 */
public class Solution149 {

    public static void main(String[] args) {
        //[[1,1],[2,2],[3,3]]
        var points = new int[][] {
                {1, 1},
                {2, 2},
                {3, 3}
        };
        System.out.println(new Solution149().maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        var maxPoints = 0;

        for (var begin = 0; begin < points.length; begin++) {
            var map = new HashMap<Double, Integer>();

            for (var end = 0; end < points.length; end++) {
                if (begin == end) {
                    continue;
                }
                var tg = (points[end][0] - points[begin][0] + 0D) / (points[end][1] - points[begin][1]);
                map.putIfAbsent(tg, 0);
                map.compute(tg, (key, value) -> value += 1);
            }

            maxPoints = Math.max(maxPoints, map.values().stream().max(Integer::compareTo).orElse(0) + 1);
        }

        return maxPoints;
    }
}
