package sierikov.leetcode.tasks.easy

import scala.annotation.tailrec

object ContainsDuplicate {
  def containsDuplicate(nums: Array[Int]): Boolean = findDuplicate(nums)

  /**
    * Checks if array contains duplicate values.
    *
    * Algorithm: iterate over array and check if accumulator contains current value
    * if so - return true, otherwise - add current value to accumulator and continue
    *
    * @param input array to check
    * @param acc accumulator for processed values
    * @return true if array contains duplicate values, false otherwise
    */
  @tailrec
  private def findDuplicate(input: Array[Int], acc: Array[Int] = Array.empty[Int]): Boolean = input match
    case Array() => false
    case Array(value, _*) if acc.contains(value) => true
    case _ => findDuplicate(input.drop(1), acc :+ input.head)
}
