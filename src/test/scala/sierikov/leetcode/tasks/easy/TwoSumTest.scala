package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class TwoSumTest extends AnyFlatSpec {
  import TwoSum._

  it should "return [0, 1]" in {
    assert(twoSum(Array(2, 7, 11, 15), 9).sameElements(Array(0, 1)))
  }

}
