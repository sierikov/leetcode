package sierikov.leetcode.tasks.medium

object MaximumMatrixSum {
  def maxMatrixSum(matrix: Array[Array[Int]]): Long = {
    val negativeCount = matrix.flatten.count(_ < 0)
    val flattenedM = matrix.flatten.map(_.abs.toLong)
    val maxSum = flattenedM.sum

    if (negativeCount % 2 != 0) maxSum - 2 * flattenedM.min
    else maxSum
  }
}
