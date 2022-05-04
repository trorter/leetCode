package example1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Andrey Ledovskikh
 */
public class Solution1679 {

    public static void main(String[] args) {
        //nums = [1,2,3,4], k = 5
//        final var nums = new int[] {1, 2 ,3 ,4};
//        final var k = 5;
        //[4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4], k =2
//        final var nums = new int[] {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
//        final var k = 2;
        //[3,1,3,4,3], k =6
        final var nums = new int[] {3,1,3,4,3};
        final var k = 6;
        System.out.println(new Solution1679().maxOperations(nums, k));
    }

    public int maxOperations(int[] nums, int k) {
        var halfSumStorage = new HashMap<Integer, Integer>();

        var result = 0;

        for (int num : nums) {

            final var dif = k - num;
            if (halfSumStorage.containsKey(dif) && halfSumStorage.get(dif) > 0) {
                result++;
                halfSumStorage.computeIfPresent(dif, (key, value) -> value -= 1);
                continue;
            }

            if (dif > 0) {
//                halfSumStorage.put(nums[i], halfSumStorage.getOrDefault(nums[i], 0) + 1);
                halfSumStorage.compute(num, (key, value) -> value = (value == null) ? 1 : value + 1);
            }
        }

        return result;
    }
}
