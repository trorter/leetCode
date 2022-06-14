package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution23 {

    public static void main(String[] args) {
        //[[1,4,5],[1,3,4],[2,6]]
        var lists = new ListNode[] {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        System.out.println(new Solution23().mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode result = null;
        ListNode head = null;

        var nextMin = 0;
        while ((nextMin = findNextMin(lists)) != Integer.MAX_VALUE) {
            if (result == null) {
                result = new ListNode(nextMin);
                head = result;
            } else {
                result.next = new ListNode(nextMin);
                result = result.next;
            }
        }

        return head;
    }

    private int findNextMin(ListNode[] lists) {
        var min = Integer.MAX_VALUE;
        var index = -1;

        for (var i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                index = i;
            }
        }

        if (min != Integer.MAX_VALUE) {
            lists[index] = lists[index].next;
        }

        return min;
    }
}
