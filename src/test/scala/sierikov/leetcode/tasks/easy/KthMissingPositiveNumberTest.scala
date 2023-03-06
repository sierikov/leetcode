package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class KthMissingPositiveNumberTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    assert(KthMissingPositiveNumber.findKthPositive(Array(2, 3, 4, 7, 11), 5) == 9)
    assert(KthMissingPositiveNumber.findKthPositive(Array(1, 2, 3, 4), 2) == 6)
  }
}
