package sierikov.leetcode.tasks.easy

object RotateString {
  def rotateString(s: String, goal: String): Boolean =
    if (s.size > goal.size) false
    else (s + s).contains(goal)
}
