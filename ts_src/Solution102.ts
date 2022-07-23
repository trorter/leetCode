class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val===undefined ? 0 : val)
        this.left = (left===undefined ? null : left)
        this.right = (right===undefined ? null : right)
    }
}

const levelOrder = (root: TreeNode | null): number[][] => {
  if (root === null) {
    return []
  }

  const result: Array<Array<number>> = []

  let queue: Array<TreeNode> = []
  queue.push(root)

  while (queue.length !== 0) {
    const tmpQueue: Array<TreeNode> = []
    const row: Array<number> = []

    for (let i = 0; i < queue.length; i++) {
      const node = queue[i]
      row.push(node.val)

      if (node.left) {
        tmpQueue.push(node.left)
      }

      if (node.right) {
        tmpQueue.push(node.right)
      }
    }

    queue = tmpQueue
    result.push(row)
  }

  return result
}

export {}
