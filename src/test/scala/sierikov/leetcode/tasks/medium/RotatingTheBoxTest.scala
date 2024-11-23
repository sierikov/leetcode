package sierikov.leetcode.tasks.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RotatingTheBoxTest extends AnyFlatSpec with Matchers {
  import RotatingTheBox._

  it should "calc rock position correctly" in {
    val box = Array(
      Array('#', '#', '*', '.', '*', '.'),
      Array('#', '#', '#', '*', '.', '.'),
      Array('#', '#', '#', '.', '#', '.')
    )
    val expected = Array(
      Array('.', '#', '#'),
      Array('.', '#', '#'),
      Array('#', '#', '*'),
      Array('#', '*', '.'),
      Array('#', '.', '*'),
      Array('#', '.', '.')
    )

    rotateTheBox(box) shouldBe expected
  }

}
