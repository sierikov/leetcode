package sierikov.leetcode.tasks.medium

object StringCompression3 {

  @scala.annotation.tailrec
  private def compress(remains: String, acc: StringBuilder = new StringBuilder()): String =
    if (remains.isEmpty()) acc.toString()
    else {
      val equal = remains.take(9).takeWhile(remains.head == _)
      acc.append(equal.size).append(equal.head)
      compress(remains.drop(equal.size), acc)
    }

  def compressedString(word: String): String = compress(word)
}
