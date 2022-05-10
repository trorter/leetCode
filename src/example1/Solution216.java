package example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andrey Ledovskikh
 */
public class Solution216 {

    public static void main(String[] args) {
        //k=3, n=7
//        var k = 3;
//        var n = 7;
        //k=9, n=45
//        var k = 9;
//        var n = 45;
        //k=9, n=45
        var k = 3;
        var n = 15;
        System.out.println(new Solution216().combinationSum3(k, n));
    }

    final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        //input parameters validation
        //min
        var kMin = 0;
        for (var kTmp = 0 ; kTmp < k; kTmp++) {
            kMin += kTmp + 1;
        }
        if (n < kMin) {
            return new ArrayList<>();
        }

        //max
        var kMax = 0;
        for (var kTmp = 0 ; kTmp < k; kTmp++) {
            kMax += 9 - kTmp;
        }
        if (kMax < n) {
            return new ArrayList<>();
        }

        //main logic
        for (var i = 1; i <= 10 - k; i++) {
            var currentTrack = new int[k];
            currentTrack[0] = i;
            found(currentTrack, k - 1, i, n);
        }

        return result;
    }

    private void found(int[] currentTrack, int leftDigits, int currentSum, int n) {
        //System.out.println("currentTrack=" + currentTrack + ", leftDigits=" + leftDigits + ", currentSum" + currentSum);
        if (leftDigits == 1) {
            for (var i = currentTrack[currentTrack.length - 2] + 1;
                 i <= 9;
                 i++) {
                if (currentSum + i == n) {
                    currentTrack[currentTrack.length - 1] = i;
                    result.add(Arrays.stream(currentTrack).boxed().toList());
                    return;
                }

                if (currentSum + i > n) {
                    return;
                }
            }

            return;
        }

        for (var i = currentTrack[currentTrack.length - 1 - leftDigits] + 1;
             i <= 10 - leftDigits;
             i++) {
            currentTrack[currentTrack.length - leftDigits] = i;
            found(currentTrack, leftDigits - 1, currentSum + i, n);
        }

    }

}
