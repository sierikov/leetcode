package sierikov.leetcode.tasks.easy

/**
  * Find the kth positive integer that is missing from an array.
  *
  * @note The array is sorted in ascending order.
  * @see [[https://leetcode.com/problems/kth-missing-positive-number/]]
  */
object KthMissingPositiveNumber {
  def findKthPositive(arr: Array[Int], k: Int): Int = (1 to arr.last + k).toList
    .filterNot(arr.contains)
    .take(k)
    .lastOption
    .getOrElse(0)
}
