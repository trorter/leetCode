package example1;

import java.util.HashSet;

/**
 * @author Andrey Ledovskikh
 */
public class Solution1695 {

    public int maximumUniqueSubarray(int[] nums) {
        var max = 0;

        var curSum = 0;
        var curPath = new HashSet<Integer>();
        var start = 0;

        for (int num : nums) {
            while (curPath.contains(num)) {
                curPath.remove(nums[start]);
                curSum -= nums[start];
                start++;
            }

            curSum += num;
            curPath.add(num);

            max = Math.max(max, curSum);
        }

        return max;
    }


}
