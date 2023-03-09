/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {
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
