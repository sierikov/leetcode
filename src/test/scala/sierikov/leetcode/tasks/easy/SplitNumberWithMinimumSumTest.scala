package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class SplitNumberWithMinimumSumTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    assert(SplitNumberWithMinimumSum.splitNum(1234) == 37)
    assert(SplitNumberWithMinimumSum.splitNum(1000) == 1)
    assert(SplitNumberWithMinimumSum.splitNum(9288) == 117)
    assert(SplitNumberWithMinimumSum.splitNum(100000) == 1)
    assert(SplitNumberWithMinimumSum.splitNum(111111) == 222)
    assert(SplitNumberWithMinimumSum.splitNum(123456) == 381)
    assert(SplitNumberWithMinimumSum.splitNum(987654) == 1047)
    assert(SplitNumberWithMinimumSum.splitNum(999999) == 1998)
  }
}
