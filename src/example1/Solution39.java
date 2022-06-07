package example1;

import java.util.*;

/**
 * @author Andrey Ledovskikh
 */
public class Solution39 {

    public static void main(String[] args) {
        var array = new int[] {2,3,6,7};
        var target = 7;
        System.out.println(new Solution39().combinationSum(array, target));
    }

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, new LinkedList<>(), target, 0);

        return this.result;
    }

    private void dfs(int[] candidates, Deque<Integer> path, int target, int index) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            this.result.add(new ArrayList<>(path));
        }

        for (var i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, path, target -candidates[i], i);
            path.removeLast();
        }
    }
}
