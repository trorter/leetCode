package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution19 {

    public static void main(String[] args) {
        //head = [1,2,3,4,5], n = 2
        var tree = new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(
                                3,
                                new ListNode(
                                        4,
                                        new ListNode(5)
                                )
                        )
                )
        );
        var n = 2;
        System.out.println(new Solution19().removeNthFromEnd(tree, n));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        var size = 1;
        var tmp = head;
        while ((tmp = tmp.next) != null) {
            size++;
        }

        if (n == size) {
            return head.next;
        }

        var count = 1;
        tmp = head;
        while ((count += 1) <= (size - n)) {
            tmp = tmp.next;
        }

        if (n == 1) {
            tmp.next = null;
        } else {
            tmp.next = tmp.next.next;
        }

        return head;
    }
}
