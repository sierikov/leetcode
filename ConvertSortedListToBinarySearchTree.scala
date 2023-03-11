/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def toList(head: ListNode, acc: Vector[Int] = Vector.empty): Vector[Int] = {
        if (head == null) acc
        else toList(head.next, acc :+ head.x)
    }

    def toBinaryTree(v: Vector[Int]): TreeNode = {
        if (v.isEmpty) null 
        else {
            val mid = v.size / 2
            val element = v(mid)
            val (left, right) = v.splitAt(mid)
            TreeNode(element, toBinaryTree(left), toBinaryTree(right.tail))
        }
    }

    def sortedListToBST(head: ListNode): TreeNode = {
        toBinaryTree(toList(head))
    }
}
