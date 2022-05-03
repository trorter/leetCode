package example1;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;

/**
 * @author Andrey Ledovskikh
 */
public class Solution101 {

    public static void main(String[] args) {
        //[1,2,2,3,4,4,3]
        //[1,2,2,2,null,2]
        final var testTree = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(2),
                        null
                ),
                new TreeNode(
                        2,
                        new TreeNode(2),
                        null
                )
        );
        System.out.println(new Solution101().isSymmetric(testTree));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root.right == null && root.left == null) {
            return true;
        }

        if ((root.right != null && root.left == null) || (root.right == null && root.left != null)) {
            return false;
        }

        final var leftQueue = new ArrayDeque<TreeNode>();
        final var rightQueue = new ArrayDeque<TreeNode>();

        var rootLeft = root.left;
        var rootRight = root.right;

        while ((!leftQueue.isEmpty() || rootLeft != null) || (!rightQueue.isEmpty() || rootRight != null)) {
            while (rootLeft != null) {
                leftQueue.addFirst(rootLeft);
                rootLeft = rootLeft.left;
            }
            while (rootRight != null) {
                rightQueue.addFirst(rootRight);
                rootRight = rootRight.right;
            }

            rootLeft = leftQueue.removeFirst();
            rootRight = rightQueue.removeFirst();

            if (rootLeft.val != rootRight.val) {
                return false;
            }

            rootLeft = rootLeft.right;
            rootRight = rootRight.left;
        }

        return true;
    }
}