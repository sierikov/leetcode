package sierikov.leetcode.tasks.easy

/**
  * Splits a number into minimum possible sum of digits.
  * For example, 4325 -> 34 + 25 = 59
  *
  * Algorithm is based on sorting digits in ascending order.
  * Then we iterate over digits by odd and even indexes saving them to left and right parts.
  * In this way we get minimum possible value for each part.
  * {{{
  *   4325 -> 2345 => 24 + 35 = 59
  * }}}
  * @see [[https://leetcode.com/problems/split-with-minimum-sum]]
  */
object SplitNumberWithMinimumSum {
  def splitNum(num: Int): Int = {
    val sorted = num.toString.sorted
    val left = sorted.sliding(1, 2).mkString
    val right = sorted.drop(1).sliding(1, 2).mkString
    left.toInt + right.toInt
  }
}
