package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution209 {

    public static void main(String[] args) {
        var target = 11;
        var nums = new int[] {1,2,3,4,5};
        System.out.println(new Solution209().minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        var min = Integer.MAX_VALUE;

        var start = 0;
        var curSum = 0;
        var count = 0;

        for (var num : nums) {
            while (target <= curSum + num - nums[start] && 0 < count) {
                curSum -= nums[start];
                count--;
                start++;
            }

            curSum += num;
            count++;

            if (target <= curSum) {
                min = Math.min(min, count);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
