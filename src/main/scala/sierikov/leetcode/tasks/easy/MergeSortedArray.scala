package sierikov.leetcode.tasks.easy

object MergeSortedArray {

  /**
    * Merge two sorted arrays in one.
    *
    * Algorithm iterates over both arrays and takes the smallest elements first.
    *
    * @note Modifies `nums1` in-place with the merged array.
    * @note `nums1` must be `n + m` long.
    * @param nums1 array of integers
    * @param m     number of elements in `nums1`
    * @param nums2 array of integers
    * @param n     number of elements in `nums2`
    * @return `nums1` with merged elements
    * @see [[https://leetcode.com/problems/merge-sorted-array]]
    */
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    val original = nums1.take(m)
    var pointer1 = 0
    var pointer2 = 0

    for (i <- 0 until m + n) {
      if (pointer1 >= m) {
        nums1.update(i, nums2(pointer2))
        pointer2 += 1
      } else if (pointer2 >= n) {
        nums1.update(i, original(pointer1))
        pointer1 += 1
      } else {
        val (left, right) = (original(pointer1), nums2(pointer2))
        if (left > right) {
          nums1.update(i, right)
          pointer2 += 1
        } else {
          nums1.update(i, left)
          pointer1 += 1
        }
      }
    }

  }
}
