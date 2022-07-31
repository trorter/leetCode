class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val ? : number, left ? : TreeNode | null, right ? : TreeNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.left = (left === undefined ? null : left)
        this.right = (right === undefined ? null : right)
    }
}

/**
 Do not return anything, modify root in-place instead.
 */
const flatten = (root: TreeNode | null): void => {
    if (root === null || (root.left === null && root.right === null)) {
        return
    }

    const vals: Array<number> = []

    const stack: Array<TreeNode> = []
    let next: TreeNode | null | undefined = root
    while (0 < stack.length || next != null) {
        while (next != null) {
            stack.push(next)
            vals.push(next.val)

            next = next.left
        }

        next = stack.pop();

        next = next?.right
    }

    let newHead: TreeNode | null = null
    let newTail: TreeNode | null = null
    for (let val of vals) {
        if (newHead == null) {
            newHead = new TreeNode(val)
            newTail = newHead
            continue
        }

        if (newTail != null) {
            newTail.right = new TreeNode(val)
            newTail = newTail.right
        }
    }

    if (newHead != null) {
        root.left = null
        root.val = newHead?.val
        root.right = newHead.right
    }
}

// [1,2,5,3,4,null,6]
const test = new TreeNode(
    1,
    new TreeNode(
        2,
        new TreeNode(3),
        new TreeNode(4)
    ),
    new TreeNode(
        5,
        null,
        new TreeNode(6)
    )
)
flatten(test)
console.log(test)

export {}
