package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class IntersectionOfTwoArraysIITest extends AnyFlatSpec {
  import IntersectionOfTwoArraysII._

  it should "pass basic test" in {
    assert(intersect(Array(1, 2, 2, 1), Array(2, 2)).sameElements(Array(2, 2)))
    assert(intersect(Array(4, 9, 5), Array(9, 4, 9, 8, 4)).sameElements(Array(4, 9)))
  }

}
