package example1.p24;

/**
 * @author Andrey Ledovskikh
 */
public class Solution24 {

    public static void main(String[] args) {
        //[1,2,3]
        var list = new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(
                                3
                        )
                ));
        var result = new Solution24().swapPairs(list);
        System.out.println(result);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var next = head;
        ListNode prev = null;
        ListNode prevprev;

        var count = 1;
        while (next != null) {
            count++;

            prevprev = prev;
            prev = next;
            next = next.next;

            if (count % 2 == 1) {
                continue;
            }

            //if swap the first pair
            if (count == 2) {
                var tmp = next.next;
                head = next;
                head.next = prev;
                prev.next = tmp;

                prev = head;
                next = head.next;
            } else if (next != null) {
                var tmp = next.next;
                prevprev.next = next;
                next.next = prev;
                prev.next = tmp;

                prev = prevprev.next;
                next = prev.next;
            }


        }

        return head;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
