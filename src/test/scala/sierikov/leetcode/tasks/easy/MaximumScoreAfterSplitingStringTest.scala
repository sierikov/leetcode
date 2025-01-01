package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MaximumScoreAfterSplitingStringTest extends AnyFlatSpec with Matchers {

  import MaximumScoreAfterSplittingString._

  it should "not count empty sub strings" in {
    maxScore("00") shouldBe 1
  }

  it should "work for example case" in {
    maxScore("011101") shouldBe 5
  }
}
