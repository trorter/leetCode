package example1;

import java.util.*;

/**
 * @author Andrey Ledovskikh
 */
public class Solution46 {

    public static void main(String[] args) {
        final var test = new int[] {0, -1, 1};
        System.out.println(new Solution46().permute(test));
    }

    private final Set<List<Integer>> result = new HashSet<>(1_000);

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            return List.of(
                    List.of(
                            nums[0]
                    )
            );
        }

        final var next = new int[nums.length];
        Arrays.fill(next, -100);

        helper(nums, next, 0);

        return new ArrayList<>(result);
    }

    private void helper(int[] nums, int[] next, int step) {
        if (step == nums.length) {
            result.add(Arrays.stream(next).boxed().toList());
            return;
        }

        for (var i = 0; i < nums.length; i++) {
            if (next[i] == - 100) {
                next[i] = nums[step];
                helper(nums, next, step + 1);
                next[i] = -100;
            }
        }
    }

}
