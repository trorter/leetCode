package example1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Andrey Ledovskikh
 */
public class Solution75 {

    public static void main(String[] args) {
        //[2,0,2,1,1,0]
        var array = new int[] {2,0,2,1,1,0};
        new Solution75().sortColors(array);
        System.out.println(Arrays.toString(array));
    }

    public void sortColors(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        var sizes = new int[3];

        for (int num : nums) {
            sizes[num] += 1;
        }

        for (var i = 0; i < nums.length; i++) {
            if (sizes[0] > 0) {
                nums[i] = 0;
                sizes[0] -= 1;
            } else if (sizes[1] > 0) {
                nums[i] = 1;
                sizes[1] -= 1;
            } else {
                nums[i] = 2;
            }
        }
    }

}
