package sierikov.leetcode.tasks.medium

object MinimumArrayEnd {
  def minEnd(n: Int, x: Int): Long = {
    var result: Long = x
    var count = n - 1
    while (count > 0) {
      result = (result + 1) | x
      count -= 1
    }
    result
  }
}
