package example1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Andrey Ledovskikh
 */
public class BSTIterator {

    private TreeNode root;
    private Deque<TreeNode> stack = new ArrayDeque();

    public BSTIterator(TreeNode root) {
        this.root = root;

        while (this.root != null) {
            stack.add(this.root);
            this.root = this.root.left;
        }
    }

    public int next() {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }

        root = stack.removeLast();
        var result = root.val;

        root = root.right;

        return result;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || root != null;
    }
}
