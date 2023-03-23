package sierikov.leetcode.tasks.easy

import scala.annotation.tailrec

object MaximumSubarray {

  /**
    * Calculates the maximum sum subarray using Kadane's algorithm.
    *
    * @param nums array of integers
    * @return maximum sum subarray
    * @see [[https://leetcode.com/problems/maximum-subarray/]]
    * @see [[https://en.wikipedia.org/wiki/Maximum_subarray_problem]]
    */
  def maxSubArray(nums: Array[Int]): Int = helper(nums)

  private type Sum = Int
  @tailrec
  private def helper(input: Array[Int], max: Sum = Int.MinValue, current: Sum = 0): Sum = input match {
    case Array() => max
    case Array(head, tail @ _*) =>
      val localMax = Math.max(head, current + head)
      val newMax = if (localMax > max) localMax else max
      helper(tail.toArray, newMax, localMax)
  }

  /**
    * Calculates the maximum sum subarray using Kadane's algorithm.
    * @note Mutable version.
    * @param input array of integers
    * @return maximum sum subarray
    * @see [[https://en.wikipedia.org/wiki/Maximum_subarray_problem]]
    */
  def mutable(input: Array[Int]): Sum = {
    var max: Int = Int.MinValue
    var sum: Int = 0

    for (value <- input) {
      sum = Math.max(value, sum + value)
      max = Math.max(sum, max)
    }
    max
  }

}
