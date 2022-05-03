package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution581 {

    public static void main(String[] args) {
        //[2,3,3,2,4]
        final var testArray = new int[] {2, 1, 1, 1, 1};
        System.out.println(new Solution581().findUnsortedSubarray(testArray));
    }

    public int findUnsortedSubarray(int[] nums) {
        var end = -1;
        var max = nums[0];

        for (var i = 1; i < nums.length; i++) {
            if (max > nums[i]) {
                end = i;
            } else {
                max = nums[i];
            }
        }

        var start = 0;
        var min = nums[nums.length - 1];
        for (var i = nums.length - 2; i >= 0; i--) {
            if (min < nums[i]) {
                start = i;
            } else {
                min = nums[i];
            }
        }

        return end - start + 1;
    }

}
