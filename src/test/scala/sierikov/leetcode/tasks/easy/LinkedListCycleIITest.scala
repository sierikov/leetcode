package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class LinkedListCycleIITest extends AnyFlatSpec {
  import LinkedListCycleII._

  val node1 = new ListNode(3)
  val node2 = new ListNode(2)
  val node3 = new ListNode(0)
  val node4 = new ListNode(-4)

  node1.next = node2
  node2.next = node3
  node3.next = node4
  node4.next = node2

  "detectCycle" should "return node where cycle begins" in {
    assert(detectCycle(node1) == node2)
  }

}
