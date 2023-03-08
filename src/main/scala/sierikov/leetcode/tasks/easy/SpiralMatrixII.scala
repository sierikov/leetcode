package sierikov.leetcode.tasks.easy

/**
  * Generate a square matrix filled with elements from 1 to n*n in spiral order.
  *
  * Example Matrix of rank 4:
  * {{{
  *   1   2  3  4
  *   12 13 14  5
  *   11 16 15  6
  *   10  9  8  7
  * }}}
  *
  * Algorithm: generate a increase monotone sequence from `start`
  *
  * @see [[https://leetcode.com/problems/split-with-minimum-sum]]
  */
object SpiralMatrixII {
  def spiralMatrix(rank: Int): List[List[Int]] = {

    /**
      * Generate a square matrix filled with elements from 1 to n*n in spiral order.
      *
      * Algorithm:
      * 1. generate a increase monotone sequence from `start` to `start + columns` (length of row)
      * 2. swap rows and columns
      * 3. generate a increase monotone sequence from `start` to `start + rows` (length of column)
      * 4. swap rows and columns
      * 5. repeat 1-4 until `rows` is 0
      *
      * @param rows number of rows
      * @param columns number of columns
      * @param start start value
      * @return matrix
      */
    def constructMatrix(rows: Int, columns: Int, start: Int): List[List[Int]] =
      if (rows == 0) List.empty
      else {
        val monotone = (start until start + columns).toList
        monotone :: constructMatrix(columns, rows - 1, start + columns).reverse.transpose
      }

    constructMatrix(rank, rank, 1)
  }
}
