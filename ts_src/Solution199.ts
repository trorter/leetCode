/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

interface TreeNode {
  val: number
  left: TreeNode
  right: TreeNode
}

const rightSideView = (root: TreeNode | null): number[] => {
  if (root === null || root === undefined) {
    return []
  }

  const result: Array<number> = []
  let queue: Array<TreeNode> = []

  queue.push(root)

  while (0 < queue.length) {
    const newQueue: Array<TreeNode> = []

    for (let i = 0; i < queue.length; i++) {
      if (queue[i].left) {
        newQueue.push(queue[i].left)
      }

      if (queue[i].right) {
        newQueue.push(queue[i].right)
      }
    }

    result.push(queue[queue.length - 1].val)
    queue = newQueue
  }

  return result
}