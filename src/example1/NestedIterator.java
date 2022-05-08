package example1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author Andrey Ledovskikh
 */
public class NestedIterator implements Iterator<Integer> {

    private final Deque<NestedInteger> queueOfLists;

    public NestedIterator(List<NestedInteger> nestedList) {

        this.queueOfLists = new ArrayDeque<>();


        queueOfLists.addAll(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }

        var next = queueOfLists.removeFirst();
        return next.getInteger();
    }

    @Override
    public boolean hasNext() {
        unrollList();

        return !queueOfLists.isEmpty();
    }

    private void unrollList() {
        while(!queueOfLists.isEmpty()) {

            // System.out.println("queueSize=" + queueOfLists.size());
            // if (queueOfLists.peekFirst().isInteger()) {
            //     System.out.println("INT=" + queueOfLists.peekFirst().getInteger());
            // } else {
            //     System.out.println("SIZE=" + queueOfLists.peekFirst().getList().size());
            // }

            if (queueOfLists.peekFirst().isInteger()) {
                break;
            }

            final var innerList = queueOfLists.removeFirst().getList();

            if (innerList.size() == 0) {
                continue;
            }

            for (var i = innerList.size() -1; i >= 0; i-- ) {
                queueOfLists.addFirst(innerList.get(i));
            }
        }
    }
}
