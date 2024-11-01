package sierikov.leetcode.tasks.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PeakIndexInMountainArrayTest extends AnyFlatSpec with Matchers {
  import PeakIndexInMountainArray._

  it should "pass example test" in {
    peakIndexInMountainArray(Array(0, 1, 0)) shouldBe 1
    peakIndexInMountainArray(Array(0, 2, 1, 0)) shouldBe 1
    peakIndexInMountainArray(Array(0, 10, 5, 2)) shouldBe 1
  }

}
