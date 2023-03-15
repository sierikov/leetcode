object Solution {
    def leftIndex(n: Int) = 2 * n + 1
    def rightIndex(n: Int) = 2 * n + 2

    def loop(root: TreeNode, index: Int, total: Int): Boolean = root match {
        case null                          => true
        case t: TreeNode if index >= total => false
        case _ =>
            loop(root.left, leftIndex(index), total) && 
            loop(root.right, rightIndex(index), total)
    }

    def size(root: TreeNode): Int = root match {
        case null        => 0
        case t: TreeNode => 1 + size(t.left) + size(t.right)
    }


    def isCompleteTree(root: TreeNode): Boolean = {
        loop(root, 0, size(root))
    }
}
