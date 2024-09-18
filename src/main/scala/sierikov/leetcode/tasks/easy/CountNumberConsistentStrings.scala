package sierikov.leetcode.tasks.easy

// Leetcode: https://leetcode.com/problems/count-the-number-of-consistent-strings
object CountNumberConsistentStrings {
  def countConsistentStrings(allowed: String, words: Array[String]): Int = {
    words.count(_.forall(allowed.contains))
  }
}
