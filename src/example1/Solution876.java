package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution876 {

    public static void main(String[] args) {
        //[1,2,3,4,5]
//        final var list = new ListNode(
//                1,
//                new ListNode(
//                        2,
//                        new ListNode(
//                                3,
//                                new ListNode(
//                                        4,
//                                        new ListNode(5)
//                                )
//                        )
//                )
//        );
        //[1]
//        final var list = new ListNode(1);
        //[1,2,3,4,5,6]
        final var list = new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(
                                3,
                                new ListNode(
                                        4,
                                        new ListNode(
                                                5,
                                                new ListNode(6)
                                                )
                                )
                        )
                )
        );
        System.out.println(new Solution876().middleNode(list));
    }

    public ListNode middleNode(ListNode head) {
        var origin = head;

        if (head == null) {
            return null;
        }

        var size = 1;
        while ((head = head.next) != null) {
            size++;
        }

        if (size == 1) {
            return origin;
        }

        var middle = (size / 2) +  ((size % 2 == 1) ? 1 : 0);

        while ((middle -= 1) >= 0 ) {
            origin = origin.next;
        }

        return origin;
    }
}
