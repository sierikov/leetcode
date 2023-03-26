package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class PascalsTriangleTest extends AnyFlatSpec {
  import PascalsTriangle._

  it should "return empty list for 0" in {
    assert(generate(0) == List())
  }

  it should "calculate triangle correctly" in {
    assert(
      generate(5) == List(
        List(1),
        List(1, 1),
        List(1, 2, 1),
        List(1, 3, 3, 1),
        List(1, 4, 6, 4, 1)
      )
    )
  }

  it should "pass stress test" in {
    assert(generate(30).size == 30)
  }
}
