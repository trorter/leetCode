package example1;

import java.util.Arrays;

/**
 * @author Andrey Ledovskikh
 */
public class Solution1151 {

    public static void main(String[] args) {
        var data = new int [] {1,0,1,0,1,0,0,1,1,0,1};
        System.out.println(new Solution1151().minSwaps(data));
    }

    public int minSwaps(int[] data) {
        var ones = Arrays.stream(data).sum();

        var curOnes = 0;
        var maxOnes = 0;

        var right = 0;
        var left = 0;
        while (right < data.length) {
            curOnes += data[right];
            right++;

            if (right - left > ones) {
                curOnes -= data[left];
                left++;
            }

            maxOnes = Math.max(maxOnes, curOnes);
        }

        return ones - maxOnes;
    }
}
