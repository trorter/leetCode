package example1.p117;

import java.util.ArrayDeque;

/**
 * @author Andrey Ledovskikh
 */
public class Solution117 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        var lair = new ArrayDeque<Node>(100);
        if (root.left != null) {
            lair.addLast(root.left);
        }
        if (root.right != null) {
            lair.addLast(root.right);
        }

        while (!lair.isEmpty()) {
            final var nextLair = new ArrayDeque<Node>(100);
            Node prev = null;

            while (!lair.isEmpty()) {
                var current = lair.removeFirst();

                if (prev != null) {
                    prev.next = current;
                }
                prev = current;

                if (current.left != null) {
                    nextLair.addLast(current.left);
                }
                if (current.right != null) {
                    nextLair.addLast(current.right);
                }
            }

            lair = nextLair;
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
}

