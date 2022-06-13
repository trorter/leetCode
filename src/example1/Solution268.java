package example1;

import java.util.Arrays;

/**
 * @author Andrey Ledovskikh
 */
public class Solution268 {

    public int missingNumber(int[] nums) {
        return (nums.length + 1) * nums.length / 2 - Arrays.stream(nums).sum();
    }
}
