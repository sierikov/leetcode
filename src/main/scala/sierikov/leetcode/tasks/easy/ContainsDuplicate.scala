package sierikov.leetcode.tasks.easy

import scala.annotation.tailrec

object ContainsDuplicate {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    val sorted = nums.sorted
    checkDuplicates(sorted.drop(1), sorted.head)
  }

  /** Checks if there are duplicates in sorted array
    * @note works only for sorted array
    * @param array sorted array to check
    * @param prev previous element
    * @return true if there are duplicates, false otherwise
    */
  @tailrec
  private def checkDuplicates(array: Array[Int], prev: Int): Boolean =
    if (array.isEmpty) false
    else if (array.head == prev) true
    else checkDuplicates(array.tail, array.head)
}
