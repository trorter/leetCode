package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution206 {

    public static void main(String[] args) {
        //[1,2,3,4,5]
        final var list = new ListNode(
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
        System.out.println(new Solution206().reverseList(list));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        final ListNode last = head;
        ListNode revers = new ListNode(head.val);

        while ((head = head.next) != null) {
            revers = new ListNode (head.val, revers);
        }

        last.next = null;
        return revers;
    }

}
