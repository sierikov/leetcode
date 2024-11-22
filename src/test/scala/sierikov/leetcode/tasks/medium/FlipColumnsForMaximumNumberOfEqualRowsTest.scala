package sierikov.leetcode.tasks.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FlipColumnsForMaximumNumberOfEqualRowsTest extends AnyFlatSpec with Matchers {

  import FlipColumnsForMaximumNumberOfEqualRows._

  it should "pass example tests" in {
    val arr = Array(
      Array(0, 0, 0),
      Array(0, 0, 1),
      Array(1, 1, 0)
    )

    maxEqualRowsAfterFlips(arr) shouldBe 2
  }

}
