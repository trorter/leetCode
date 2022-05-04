package example1;

/**
 * @author Andrey Ledovskikh
 */
public class Solution104 {

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        final var tree = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );
        System.out.println(new Solution104().maxDepth(tree));
    }

    private int maxDeep = 0;

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        helper(root, 1);

        return maxDeep;
    }

    private void helper(TreeNode root, int deep) {
        if (root.left != null) {
            helper(root.left, deep + 1);
        }

        if (root.right != null) {
            helper(root.right, deep + 1);
        }

        this.maxDeep = Math.max(deep, this.maxDeep);
    }
}
