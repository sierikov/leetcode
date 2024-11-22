package sierikov.leetcode.tasks.medium

// leetcode: https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/description/
object FlipColumnsForMaximumNumberOfEqualRows {

  def maxEqualRowsAfterFlips(matrix: Array[Array[Int]]): Int = {
    matrix
      .map { row =>
        row.map(_ ^ row.head).toSeq
      }
      .groupMapReduce(identity)(_ => 1)(_ + _)
      .values
      .max
  }
}
