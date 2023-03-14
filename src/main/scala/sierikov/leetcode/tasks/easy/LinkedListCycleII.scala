package sierikov.leetcode.tasks.easy

object LinkedListCycleII {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  /**
   * Detects the first node of the cycle in a linked list.
   * Algorithm:
   * 1. Create a table of visited nodes
   * 2. Traverse the list and check if the current node is in the table
   * 3. If it is, return the node - cycle detected, otherwise add the node to the table and continue.
   *
   *
   * @param head head of the linked list
   * @return the first node of the cycle or null if there is no cycle
   * @see [[https://leetcode.com/problems/linked-list-cycle-ii/]]
   */
  def detectCycle(head: ListNode): ListNode = {
    def recurse(node: ListNode, table: Map[ListNode, Boolean]): ListNode = {
      Option(node) match {
        case None => null
        case Some(n) =>
          if (table.get(n).isDefined) n
          else recurse(n.next, table + (n -> true))
      }
    }

    recurse(head, Map())
  }
}
