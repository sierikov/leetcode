package sierikov.leetcode.tasks.easy

object CircularSentence {
  def isCircularSentence(s: String): Boolean = {
    val words = s.split(" ")
    if (words.length == 1)
      words.head.head == words.head.last
    else
      words.zip(words.tail :+ words.head).forall { case (a, b) =>
        a.last == b.head
      }
  }
}
