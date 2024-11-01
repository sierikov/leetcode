package sierikov.leetcode.tasks.easy

// leetcode: https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/
object DeleteCharactersMakeFancyString {
  def makeFancyString(s: String): String = s.zipWithIndex
    .filter { case (element, index) =>
      index < 2 || (s(index) != s(index - 1) || s(index) != s(index - 2))
    }
    .map(_._1)
    .mkString
}
