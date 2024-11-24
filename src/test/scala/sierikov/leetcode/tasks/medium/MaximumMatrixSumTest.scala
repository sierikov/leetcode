package sierikov.leetcode.tasks.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MaximumMatrixSumTest extends AnyFlatSpec with Matchers {

  import MaximumMatrixSum._

  it should "detect maximum sum on odd matrix" in {
    val matrix = Array(Array(1, 2, 3), Array(-1, -2, -3), Array(1, 2, 3))
    maxMatrixSum(matrix) shouldBe 16
  }

  it should "detect maximum sum on even matrix" in {
    val matrix = Array(Array(1, 1), Array(-1, -1))
    maxMatrixSum(matrix) shouldBe 4
  }

  it should "work for all positive values" in {
    val matrix = Array(
      Array(10000, 10000, 10000),
      Array(10000, 10000, 10000),
      Array(10000, 10000, 10000)
    )

    maxMatrixSum(matrix) shouldBe 90000
  }

  it should "work for all negative values" in {
    val matrix = Array(
      Array(9, -3, -4),
      Array(-4, -1, -3),
      Array(-6, -3, -3)
    )

    maxMatrixSum(matrix) shouldBe 36
  }

}
