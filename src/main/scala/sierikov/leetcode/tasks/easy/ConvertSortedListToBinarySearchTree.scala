package sierikov.leetcode.tasks.easy

import scala.annotation.tailrec

object ConvertSortedListToBinarySearchTree {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }


  /**
   * Convert linked list to vector
   * @param head head of linked list
   * @param acc accumulator for tail recursion
   * @return vector of elements in the same order as in the linked list
   */
  @tailrec
  private def toList(head: ListNode, acc: Vector[Int] = Vector.empty): Vector[Int] = {
    if (head == null) acc
    else toList(head.next, acc :+ head.x)
  }

  /**
   * Convert vector to binary tree
   * Algorithm:
   * 1. Find the middle element of the vector
   * 2. Recursively create left and right subtrees
   *
   * Illustration:
   * Input: 1 -> 2 -> 3 -> 4 -> 5
   *
   * Middle element: 3.
   * Left subtree: 1 -> 2.
   * Right subtree: 4 -> 5.
   *
   * Result:
   *{{{
   *   3
   *  / \
   * 1   4
   * \   \
   *  2   5
   *}}}
   * @param v vector of elements
   * @return binary tree
   * @see [[https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/]]
   */
  private def toBinaryTree(v: Vector[Int]): TreeNode = {
    if (v.isEmpty) null
    else {
      val mid = v.size / 2
      val element = v(mid)
      val (left, right) = v.splitAt(mid)
      TreeNode(element, toBinaryTree(left), toBinaryTree(right.tail))
    }
  }

  def sortedListToBST(head: ListNode): TreeNode = toBinaryTree(toList(head))

}
