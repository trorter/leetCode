/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {boolean}
 */
let hasPathSum = function(root, targetSum) {
    return dfs(root, targetSum, 0, 0);
};

/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @param {number} curSum
 * @param {number} steps
 * @return {boolean}
 */
let dfs = (root, targetSum, curSum, steps) => {
    if (!root) {
        return false
    }

    // if (0 < steps && root.val === targetSum && !root.right && !root.left) {
    //     return false;
    // }

    if (root.val + curSum === targetSum) {
        return true
    }

    if (root.left) {
        return dfs(root.left, targetSum, root.val + curSum, steps + 1)
    }
    if (root.right) {
        return dfs(root.right, targetSum, root.val + curSum, steps + 1)
    }

    return false;
}