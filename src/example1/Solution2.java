package example1;

import java.util.*;

/**
 * @author Andrey Ledovskikh
 */
public class Solution2 {

    public static void main(String[] args) {
        var test = new int[][] {{1,2,3},{4,5,6}};
        new Solution2().intersection(test);
    }

    public List<Integer> intersection(int[][] nums) {
        var result = new HashMap<Integer, Integer>();

        for (var array
                : nums) {
            for (var num
                    : array) {
                result.put(num, result.getOrDefault(num, 0) + 1);
            }
        }

        var cross = result.values().stream().mapToInt(o -> o).max().getAsInt();

        if (nums.length > 1 && cross == 1) {
            return new ArrayList<Integer>();
        }
        return result.entrySet().stream().filter(item -> item.getValue() == cross).map(Map.Entry::getKey).sorted().toList();

    }
}
