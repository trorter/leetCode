import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andrey Ledovskikh
 */
public class Solution46 {

    public static void main(String[] args) {
        var test = new int[] {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(new Solution46().permuteUnique(test));
    }

    private final List<List<Integer>> result = new ArrayList<>(1_000);

    public List<List<Integer>> permuteUnique(int[] nums) {
        final var curNum = new int[nums.length];
        Arrays.fill(curNum, -100);

        helper(nums, curNum, 0);

        return result;
    }

    private void helper(int[] nums, int[] curNum, int counter) {
        if (counter == nums.length) {
            var newList = Arrays.stream(curNum).boxed().toList();
            if (!result.contains(newList)) {
                result.add(newList);
            }
            return;
        }

        for (var i = 0; i < nums.length; i++) {
            if (curNum[i] == -100) {
                curNum[i] = nums[counter];
                helper(nums, curNum, counter + 1);
                curNum[i] = -100;
            }
        }
    }

}
