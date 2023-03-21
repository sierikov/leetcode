package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class NumberOfZeroFilledSubarraysTest extends AnyFlatSpec {
  import NumberOfZeroFilledSubarrays.*

  it should "return 0 for array with no zeros" in {
    assert(zeroFilledSubarray(Array(1, 2, 3)) == 0)
  }

  it should "pass basic test" in {
    assert(zeroFilledSubarray(Array(1, 3, 0, 0, 2, 0, 0, 4)) == 6)
    assert(zeroFilledSubarray(Array(0, 0, 0, 2, 0, 0)) == 9)
    assert(zeroFilledSubarray(Array(0, 2, 0, 0, 0, 3, 0)) == 8)
  }

}
