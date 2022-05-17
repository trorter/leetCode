import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Andrey Ledovskikh
 */
public class Solution599 {

    public static void main(String[] args) {
        //["Shogun","Tapioca Express","Burger King","KFC"]
        //["KFC","Shogun","Burger King"]
//        var list1 = new String[] {"Shogun","Tapioca Express","Burger King","KFC"};
//        var list2 = new String[] {"KFC","Shogun","Burger King"};

        //["Shogun","Tapioca Express","Burger King","KFC"]
        //["KFC","Burger King","Tapioca Express","Shogun"]
        var list1 = new String[] {"Shogun","Tapioca Express","Burger King","KFC"};
        var list2 = new String[] {"KFC","Burger King","Tapioca Express","Shogun"};
        var result = new Solution599().findRestaurant(list1, list2);
        System.out.println(Arrays.toString(result));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        var map = new HashMap<String, Integer>(100);

        for (var i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        var min = Integer.MAX_VALUE;
        var result = new ArrayList<String>(100);

        for (var j = 0; j < list2.length; j++) {
            if (!map.containsKey(list2[j])) {
                continue;
            }

            var sum = map.get(list2[j]) + j;
            if (sum < min) {
                min = sum;

                result.clear();
                result.add(list2[j]);
            } else if (min == sum) {
                result.add(list2[j]);
            }

        }

        return result.toArray(String[]::new);
    }
}