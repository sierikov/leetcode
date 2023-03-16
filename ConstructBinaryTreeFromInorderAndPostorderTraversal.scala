
/**
* @see [[https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/]]
* @see [[https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solutions/3303927/scala-clean-simple-recursive-with-explanation/?languageTags=scala]]
*/
object Solution {

    def last[T](ai:Array[T]): T = ai(ai.length-1)
    def safeTail[T](ai:Array[T]): Array[T] = ai.drop(1)

    def splitAtIndex[T](ai:Array[T], index:Int): (Array[T], Array[T]) = 
        ai.dropRight(1).splitAt(index)

    def splitAtValue[T](ai:Array[T], value:T): (Array[T], Array[T]) = {
        val (left, rightWithValue) = ai.span(_!=value)
        val right = safeTail(rightWithValue)
        (left, right)
    } 

    def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
        if(postorder.length==0) null
        else{
            val rootValue = last(postorder)
            val (inOrderLeft, inOrderRight) = splitAtValue(inorder, rootValue)
            val (postOrderLeft, postOrderRight) = splitAtIndex(postorder, inOrderLeft.length)
            
            new TreeNode(
                _value = rootValue, 
                _left = buildTree(inOrderLeft, postOrderLeft),
                _right = buildTree(inOrderRight, postOrderRight)
            )
        }
    }
}
