package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution223 {

    public static void main(String[] args) {
        //-3
        //0
        //3
        //4
        //0
        //-1
        //9
        //2
//        System.out.println(new Solution223().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        //ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
//        System.out.println(new Solution223().computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        //-2
        //-2
        //2
        //2
        //2
        //-2
        //4
        //2
//        System.out.println(new Solution223().computeArea(-2, -2, 2, 2, 2, -2, 4, 2));
        //-3
        //0
        //3
        //4
        //0
        //-1
        //9
        //2
//        System.out.println(new Solution223().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        //-3
        //-3
        //3
        //-1
        //-2
        //-2
        //2
        //2
        //System.out.println(new Solution223().computeArea(-3, -3, 3, -1, -2, -2, 2, 2));
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        var firstSquare = Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1);
        var secondSquare = Math.abs(bx2 - bx1) * Math.abs(by2 - by1);

        //find crossing
        var bottom = Math.max(ay1, by1);
        var high = Math.min(ay2, by2);
        var left = Math.max(ax1, bx1);
        var right = Math.min(ax2, bx2);
        var areCrossed = left < right && bottom < high;

        return firstSquare + secondSquare - (areCrossed ? Math.abs(bottom - high) * Math.abs(left - right) : 0);
    }
}
