package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution494 {

    public static void main(String[] args) {
        var nums = new int [] {1,1,1,1,1};
        var target = 3;
        System.out.println(new Solution494().findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, 0, target);
    }

    private int helper(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        return helper(nums, index + 1, sum + nums[index], target)
                + helper(nums, index + 1, sum - nums[index], target);
    }

}
