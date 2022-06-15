package example1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Andrey Ledovskikh
 */
public class Solution42 {

  public static void main(String[] args) {
    var height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(new Solution42().trap(height));
  }

  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    var water = new int[height.length];

    var maxHeight = 0;
    for (var i = 0; i < height.length; i++) {
      maxHeight = Math.max(maxHeight, height[i]);
      water[i] = maxHeight;
    }

    maxHeight = 0;
    for (var i = height.length - 1; 0 <= i; i--) {
      maxHeight = Math.max(maxHeight, height[i]);
      water[i] = Math.min(water[i], maxHeight) - height[i];
    }

    return Arrays.stream(water).sum();
  }
}
