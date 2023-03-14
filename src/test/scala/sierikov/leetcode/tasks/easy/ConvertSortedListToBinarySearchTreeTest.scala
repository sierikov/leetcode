package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class ConvertSortedListToBinarySearchTreeTest extends AnyFlatSpec {

  import ConvertSortedListToBinarySearchTree.*

  val list = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))))
  val expected = new TreeNode(0, new TreeNode(-3, new TreeNode(-10)), new TreeNode(9, new TreeNode(5)))

  "ConvertSortedListToBinarySearchTree" should "convert sorted list to binary search tree" in {
    val r = sortedListToBST(list)

    def check(r: TreeNode, e: TreeNode): Boolean = {
      if (r == null && e == null) true
      else if (r == null || e == null) false
      else r.value == e.value && check(r.left, e.left) && check(r.right, e.right)
    }

    assert(check(r, expected))
  }

}
