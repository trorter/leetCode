package example1;

/**
 * @author Andrey Ledovskikh
 */
public class MyLinkedList {

    class MyLinkedListNode {
        private int value;

        private MyLinkedListNode perv;
        private MyLinkedListNode next;

        MyLinkedListNode(){}

        MyLinkedListNode(int value) {
            this.value = value;
        }

        MyLinkedListNode(int value, MyLinkedListNode perv, MyLinkedListNode next) {
            this.value = value;
            this.perv = perv;
            this.next = next;
        }
    }

    private MyLinkedListNode head = null;
    private MyLinkedListNode tail = null;
    private int size = 0;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (size == 0
                || index >= size) return -1;

        var tmp = head;
        for(var i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        return tmp.value;
    }

    public void addAtHead(int val) {
        size++;

        if (size == 1) {
            head = new MyLinkedListNode(val);
            tail = head;
        } else if (size == 2) {
            head = new MyLinkedListNode(
                    val,
                    null,
                    head);
            tail.perv = head;
        } else {
            head = new MyLinkedListNode(
                    val,
                    null,
                    head);
        }
    }

    public void addAtTail(int val) {
        size++;

        if (size == 1) {
            head = new MyLinkedListNode(val);
            tail = head;
        } else {
            tail.next = new MyLinkedListNode(
                    val,
                    tail,
                    null);
            tail = tail.next;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;

        var tmp = head;
        for(var i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        if (tmp == null) {
            tail.next = new MyLinkedListNode(
                    val,
                    tail,
                    null
            );
            tail = tail.next;
        } else {
            tmp.perv.next = new MyLinkedListNode(
                    val,
                    tmp.perv,
                    tmp
            );
        }

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) return;
        if (size == 1 && index == 0) {
            head = null;
            tail = null;
            return;
        }
        if (size > 1 && index == 0) {
            head = head.next;
            return;
        }

        var tmp = head;
        for(var i = 0; i < index; i++) {
            tmp = tmp.next;
        }


        if (tail == tmp) {
            tail = tmp.perv.next;
        }
        tmp.perv.next = tmp.next;

        size--;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();

        var tmp = head;
        builder.append("[");
        while (tmp != null) {
            builder.append(tmp.value).append(", ");

            tmp = tmp.next;
        }
        builder.append("]");

        return builder.toString();
    }
}
