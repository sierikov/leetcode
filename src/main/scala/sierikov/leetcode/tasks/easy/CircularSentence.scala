package sierikov.leetcode.tasks.easy

object CircularSentence {
  def isCircularSentence(s: String): Boolean = {
    val words = s.split(" ")
    words.zip(words.tail :+ words.head).forall {
      case (a, b) => a.last == b.head
    }
  }
}
