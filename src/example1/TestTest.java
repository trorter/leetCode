package example1;

/**
 * @author Andrey Ledovskikh
 */
public class TestTest {

    public static void main(String[] args) {
//        System.out.println(isPossible());
    }

    public static String isPossible(int a, int b, int c, int d) {
        if ((c - a) % b != 0) {
            return "NO";
        }
        if ((d - b) % a != 0) {
            return "NO";
        }

        return "YES";
    }
}
