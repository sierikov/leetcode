package sierikov.leetcode.tasks.easy

import scala.annotation.tailrec

object PascalsTriangle {
  def generate(numRows: Int): List[List[Int]] = numRows match {
    case 0 => List.empty
    case 1 => List(List(1))
    case 2 => List(List(1), List(1, 1))
    case _ => helper(numRows - 2, List(List(1), List(1, 1)))
  }

  @tailrec
  def helper(row: Int, acc: List[List[Int]]): List[List[Int]] =
    if (row == 0) acc
    else {
      val current = 1 +: List(acc.last.sliding(2).map(_.sum)).flatten :+ 1
      helper(row - 1, acc :+ current)
    }
}
