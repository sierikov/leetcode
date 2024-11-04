package sierikov.leetcode.tasks.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class StringCompression3Test extends AnyFlatSpec with Matchers {
  import StringCompression3._

  it should "pass basic tests" in {
    compressedString("aaaaaaaaaaaaaabb") shouldBe "9a5a2b"
    compressedString("abcde") shouldBe "1a1b1c1d1e"
  }
}
