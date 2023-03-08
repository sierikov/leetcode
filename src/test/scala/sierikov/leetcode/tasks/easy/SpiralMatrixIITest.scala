package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class SpiralMatrixIITest extends AnyFlatSpec {
  it should "pass basic tests" in {
    assert(SpiralMatrixII.spiralMatrix(1) == List(List(1)))
    assert(SpiralMatrixII.spiralMatrix(2) == List(List(1, 2), List(4, 3)))
    assert(SpiralMatrixII.spiralMatrix(3) == List(List(1, 2, 3), List(8, 9, 4), List(7, 6, 5)))
    assert(
      SpiralMatrixII.spiralMatrix(4) == List(List(1, 2, 3, 4),
                                             List(12, 13, 14, 5),
                                             List(11, 16, 15, 6),
                                             List(10, 9, 8, 7)
      )
    )
  }
}
