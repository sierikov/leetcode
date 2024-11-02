package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CircularSentenceTest extends AnyFlatSpec with Matchers {
  import CircularSentence._

  it should "detect circular sentence" in {
    isCircularSentence("leetcode exercises sound delightful") shouldBe true
    isCircularSentence("Leetcode is cool") shouldBe false
  }

  it should "work for one word" in {
    isCircularSentence("eebee") shouldBe true
    isCircularSentence("sentence") shouldBe false
  }

  it should "work for circular case" in {
    isCircularSentence("Leetcode eisc cool") shouldBe false
    isCircularSentence("leetcode eisc cool") shouldBe true
  }
}
