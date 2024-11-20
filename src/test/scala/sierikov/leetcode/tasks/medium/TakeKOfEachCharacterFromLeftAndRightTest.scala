package sierikov.leetcode.tasks.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TakeKOfEachCharacterFromLeftAndRightTest extends AnyFlatSpec with Matchers {

  import TakeKOfEachCharacterFromLeftAndRight._

  it should "find minimum amount of minutes to take K chars" in {
    takeCharacters("aabaaaacaabc", 2) shouldBe 8
  }

  it should "return -1 if selection is not possible" in {
    takeCharacters("a", 1) shouldBe -1
  }

}
