package sierikov.leetcode.tasks.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MinimumArrayEndTest extends AnyFlatSpec with Matchers {
  import MinimumArrayEnd._

  it should "pass basic tests" in {
    minEnd(3, 4) shouldBe 6
    minEnd(2, 7) shouldBe 15
  }
}
