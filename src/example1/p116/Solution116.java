package example1.p116;

import java.util.ArrayDeque;

/**
 * @author Andrey Ledovskikh
 */
public class Solution116 {

    public static void main(String[] args) {
        //[1,2,3,4,5,6,7]
        final var root = new Node(
                1,
                new Node(
                        2,
                        new Node(4),
                        new Node(5),
                        null
                ),
                new Node(
                        3,
                        new Node(6),
                        new Node(7),
                        null
                ),
                null
        );
        System.out.println(new Solution116().connect(root));
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }

        var queue = new ArrayDeque<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var newQueue = new ArrayDeque<Node>();

            Node next;
            Node prev = null;
            while ((next = queue.pollFirst()) != null) {
                if (prev == null) {
                    prev = next;
                } else {
                    prev.next = next;
                    prev = next;
                }

                if (next.left == null) {
                    continue;
                }

                newQueue.addLast(next.left);
                newQueue.addLast(next.right);
            }

            queue = newQueue;
        }

        return root;
    }

}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}

