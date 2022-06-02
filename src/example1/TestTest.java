package example1;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Andrey Ledovskikh
 */
public class TestTest {

    public static void main(String[] args) {
//        System.out.println(isPossible());
        var map = new HashMap<String, String>();
        map.put("aa", null);
        map.put(null, null);
        map.put(null, "1");
        System.out.println(map);

        var set = new HashSet<String>();

        var arraylist = new ArrayList<Integer>();

        var linkedList = new LinkedList<Integer>();

        var str = new String("111").intern();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

        }

        var arr = new int[] {1, 2, 3, 4};
        var index = Arrays.stream(arr).reduce((a, b) -> a * 10 + b).getAsInt();
        System.out.println("index=" + index);

        var testString = "test";
        List<String> testList = new ArrayList<>();
        testList.add("111");

        testList = testList.stream().filter(a -> a.equals(testString)).toList();
        System.out.println(testList);

        testString.chars().forEach(ch -> {
            if (ch == testString.charAt(1)) {
                return;
            }
            System.out.println("ch=" + ch);
        });

        String[] strings = testList.toArray(new String[0]);

        testString.matches("");

        var queue = new PriorityQueue<Integer> (1000);
        queue.stream().toList();

        var secondQueue = new PriorityQueue<String>();
        secondQueue.addAll(testList);

        "aaaaa".replaceAll("", "").charAt(0);

        var rrr = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        var yyy = Map.of(1, 1,
                2, 2,
                3, 3,
                4, 4,
                5, 5,
                6, 6,
                7, 7,
                8, 8,
                9, 9,
                10, 10
        );
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
