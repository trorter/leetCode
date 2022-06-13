package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution1491 {

    public static void main(String[] args) {
        var salary = new int[] {4000,3000,1000,2000};
        System.out.println(new Solution1491().average(salary));
    }

    public double average(int[] salary) {
        if (salary.length <= 2) {
            return 0D;
        }

        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;

        var count = 0;
        var sum = 0;

        for (var cur : salary) {
            sum += cur;
            count++;

            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }

        return (sum + 0D - min - max) / (count - 2);
    }
}
