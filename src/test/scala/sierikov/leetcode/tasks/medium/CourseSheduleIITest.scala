package sierikov.leetcode.tasks.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CourseSheduleIITest extends AnyFlatSpec with Matchers {
  import CourseSheduleII._

  it should "pass example test" in {
    val result = findOrder(
      4,
      Array(Array(1, 0), Array(2, 0), Array(3, 1), Array(3, 2))
    )

    result should (equal(Array(0, 2, 1, 3)).or(equal(Array(0, 1, 2, 3))))
  }

  it should "detect cycles in the graph" in {
    val result = findOrder(
      4,
      Array(Array(1, 0), Array(2, 0), Array(3, 1), Array(0, 3))
    )

    result shouldBe Array.emptyIntArray
  }
}
