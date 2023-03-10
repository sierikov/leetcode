/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */

/**
 * Algorithm: Add all list to Array buffer, generate nextInt and access the element in constant time.
 * @note: this implementation is left without tests
 * @see [[https://docs.scala-lang.org/overviews/collections-2.13/performance-characteristics.html]]
 * @see [[https://leetcode.com/problems/linked-list-random-node]]
 */
import scala.collection.mutable.ArrayBuffer
class Solution(_head: ListNode) {
  val rand = new scala.util.Random
  var marr: ArrayBuffer[Int] = ArrayBuffer.empty[Int]
  var curr: ListNode = _head

  while (curr != null) {
    marr += curr.x
    curr = curr.next
  }

  def getRandom(): Int = {
    marr(rand.nextInt(marr.size))
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(head)
 * var param_1 = obj.getRandom()
 */
