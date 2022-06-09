package example1.p98;

import java.util.ArrayDeque;

/**
 * @author Andrey Ledovskikh
 */
public class Solution98 {

    public static void main(String[] args) {
        var root = new TreeNode(
                2,
                new TreeNode(1),
                new TreeNode(3)
        );
        System.out.println(new Solution98().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        var queue = new ArrayDeque<TreeNode>();
        Integer prev = null;

        while (!queue.isEmpty() || root != null) {

            while (root != null) {
                queue.push(root);
                root = root.left;
            }

            root = queue.pop();

            if (prev != null && root.val <= prev) {
                return false;
            }

            prev = root.val;
            root = root.right;
        }

        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }   TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }