package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class ReshapeTheMatrixTest extends AnyFlatSpec {
  import ReshapeTheMatrix._

  it should "pass the first example" in {
    val matrix = Array(Array(1, 2), Array(3, 4))
    val r = 1
    val c = 4
    val expected = Array(Array(1, 2, 3, 4))
    assert(matrixReshape(matrix, r, c) === expected)
  }

  it should "return the same matrix if impossible to reshape" in {
    val matrix = Array(Array(1, 2), Array(3, 4))
    val r = 2
    val c = 3
    val expected = Array(Array(1, 2), Array(3, 4))
    assert(matrixReshape(matrix, r, c) === expected)
  }

}
