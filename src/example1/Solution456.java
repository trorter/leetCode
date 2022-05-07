package example1;

import java.util.ArrayDeque;

/**
 * @author Andrey Ledovskikh
 */
public class Solution456 {

    public static void main(String[] args) {
        //[-1,3,2,0]
//        var problem = new int[] {-1, 3, 2, 0};
        //[3,5,0,3,4]
//        var problem = new int[] {3, 5, 0, 3, 4};
        //[6,12,3,4,6,20,11]
        var problem = new int[] {6,12,3,4,6,20,11};
        System.out.println(new Solution456().find132pattern(problem));
    }

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        final var mins = new int[nums.length];
        var min = Integer.MAX_VALUE;

        for (var i = 0; i < mins.length; i++) {
            min = Math.min(min, nums[i]);
            mins[i] = min;
        }

        final var stack = new ArrayDeque<Integer>();

        for (var i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > mins[i]) {
                while (!stack.isEmpty() && stack.peek() <= mins[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);
            }
        }

        return false;
    }

}
