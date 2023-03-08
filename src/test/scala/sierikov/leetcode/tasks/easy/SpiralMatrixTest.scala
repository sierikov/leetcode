package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class SpiralMatrixTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    assert(
      SpiralMatrix.spiralOrder(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))) ==
        List(1, 2, 3, 6, 9, 8, 7, 4, 5)
    )
  }

  it should "work for any matrix" in {
    assert(
      SpiralMatrix.spiralOrder(Array(Array(7), Array(9), Array(6))) ==
        List(7, 9, 6)
    )
    assert(
      SpiralMatrix.spiralOrder(
        Array(Array(1), Array(2), Array(3), Array(4), Array(5), Array(6), Array(7), Array(8), Array(9), Array(10))
      ) ==
        List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    )
    assert(
      SpiralMatrix.spiralOrder(Array(Array(1, 2, 3, 1), Array(4, 5, 6, 4), Array(7, 8, 9, 7), Array(7, 8, 9, 7))) ==
        List(1, 2, 3, 1, 4, 7, 7, 9, 8, 7, 7, 4, 5, 6, 9, 8)
    )
  }

  it should "return empty list for empty matrix" in {
    assert(
      SpiralMatrix.spiralOrder(Array.empty) == List.empty
    )
  }
}
