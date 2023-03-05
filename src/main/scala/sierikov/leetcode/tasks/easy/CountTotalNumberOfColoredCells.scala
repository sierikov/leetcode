package sierikov.leetcode.tasks.easy

/**
  * Count Total Number of Colored Cells
  * Ans is sum of arithmatic of 4 of (n-1) terms + 1.
  * {{{
  * for n = 1, ans = 1
  * for n = 2, ans = 1 + 4
  * for n = 3, ans = 1 + 4 + 8
  * for n = 4, ans = 1 + 4 + 8 + 12
  * }}}
  * So from above observation we conclude that
  * we need to return 1+ (arithmatic sum of first n-1 terms of 4)
  *
  * @see [[https://leetcode.com/problems/count-total-number-of-colored-cells]]
  */
object CountTotalNumberOfColoredCells {
  def coloredCells(n: Int): Long = {
    (Math.pow(n, 2) + Math.pow(n - 1, 2)).toLong
  }
}
