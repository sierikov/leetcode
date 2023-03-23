package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class MaximumSubarrayTest extends AnyFlatSpec {
  import MaximumSubarray._
  it should "find max subarray" in {
    assert(maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)) == 6)
    assert(maxSubArray(Array(1)) == 1)
    assert(maxSubArray(Array(5, 4, -1, 7, 8)) == 23)
  }

  it should "work on negative numbers" in {
    assert(maxSubArray(Array(-2, -1)) == -1)
  }

  it should "calculate with mutable and immutable algoritms" in {
    val arr = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    assert(maxSubArray(arr) == mutable(arr))
  }
}
