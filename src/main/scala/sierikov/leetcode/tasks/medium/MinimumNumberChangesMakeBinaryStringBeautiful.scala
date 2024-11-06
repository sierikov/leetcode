package sierikov.leetcode.tasks.medium

object MinimumNumberChangesMakeBinaryStringBeautiful {
  def minChanges(s: String): Int = {
    s.grouped(2).count(p => p(0) != p(1))
  }
}
