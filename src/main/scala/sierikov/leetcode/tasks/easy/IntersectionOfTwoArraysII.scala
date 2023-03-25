package sierikov.leetcode.tasks.easy

import scala.annotation.tailrec

object IntersectionOfTwoArraysII {

  /**
    * Calculates intersection of two arrays.
    *
    * Algorithm: Sort arrays and iterate over arrays until one of them is empty.
    *
    * @note can be done with built-in `intersect` function
    * @param nums1 first array of integers
    * @param nums2 second array of integers
    * @return array of integers that are present in both arrays
    * @see [[https://leetcode.com/problems/intersection-of-two-arrays-ii/]]
    */
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val sorted1 = nums1.sorted
    val sorted2 = nums2.sorted

    @tailrec
    def loop(array1: Array[Int],
             array2: Array[Int],
             pointer1: Int = 0,
             pointer2: Int = 0,
             acc: Array[Int] = Array.empty
    ): Array[Int] = {
      if (pointer1 >= array1.length || pointer2 >= array2.length) {
        acc
      } else {
        val (a, b) = (array1(pointer1), array2(pointer2))
        if (a == b) loop(array1, array2, pointer1 + 1, pointer2 + 1, acc :+ a)
        else if (a > b) loop(array1, array2, pointer1, pointer2 + 1, acc)
        else loop(array1, array2, pointer1 + 1, pointer2, acc)
      }
    }

    loop(sorted1, sorted2)
  }
}
