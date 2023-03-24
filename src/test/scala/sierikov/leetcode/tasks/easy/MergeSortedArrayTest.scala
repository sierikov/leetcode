package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class MergeSortedArrayTest extends AnyFlatSpec {
  import MergeSortedArray._

  it should "merge two sorted arrays" in {
    val nums1 = Array(1, 2, 3, 0, 0, 0)
    val nums2 = Array(2, 5, 6)
    val expected = Array(1, 2, 2, 3, 5, 6)
    merge(nums1, 3, nums2, 3)
    assert(nums1.sameElements(expected))
  }
}
