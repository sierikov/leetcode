package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RotateStringTest extends AnyFlatSpec with Matchers {
  import RotateString._

  it should "detect rotations" in {
    rotateString("abcde", "cdeab") shouldBe true
    rotateString("abcde", "abced") shouldBe false
  }

  it should "fail if goal is less than initial" in {
    rotateString("aa", "a") shouldBe false
  }
}
