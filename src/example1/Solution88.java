package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution88 {

    public static void main(String[] args) {
        //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        final var nums1 = new int[] {1, 2, 3, 0, 0, 0};
        final var m = 3;
        final var nums2 = new int[] {2, 5, 6};
        final var n = 3;
        new Solution88().merge(nums1, m, nums2, n);
        System.out.println(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        var search1 = m - 1;
        var search2 = n - 1;
        var insert = nums1.length - 1;

        while (insert >= 0) {
            if (search1 < 0 && search2 >= 0) {
                nums1[insert] = nums2[search2];
                search2--;
                insert--;
                continue;
            }

            if (search2 < 0 && search1 >= 0) {
                nums1[insert] = nums1[search1];
                search1--;
                insert--;
                continue;
            }

            if (nums1[search1] > nums2[search2]) {
                nums1[insert] = nums1[search1];
                search1--;
                insert--;
            } else {
                nums1[insert] = nums2[search2];
                search2--;
                insert--;
            }
        }

    }
}
