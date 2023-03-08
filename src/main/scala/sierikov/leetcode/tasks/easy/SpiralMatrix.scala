package sierikov.leetcode.tasks.easy

object SpiralMatrix {

  /**
    * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    *
    * Algorithm: moves sequentially in a clockwise direction, starting from the top left corner of the matrix.
    * After each turn the processed elements are removed from the matrix.
    *
    * @note the `drop` was used instead of `tail` to avoid ArrayIndexOutOfBoundsException`
    *
    * @param matrix 2D array of integers
    * @return list of integers in spiral order
    *
    * @see [[https://leetcode.com/problems/spiral-matrix/]]
    */
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    def readClockWiser(i: Array[Array[Int]], d: String = "right"): Array[Int] = {
      if (i.isEmpty) return Array.empty
      d match {
        case "right" => {
          val selected = i.headOption.getOrElse(Array.empty[Int])
          val rest = i.drop(1)
          selected ++ readClockWiser(rest, "down")
        }
        case "down" => {
          val selected = i.flatMap(_.lastOption)
          val rest = i.map(_.dropRight(1))
          selected ++ readClockWiser(rest, "left")
        }
        case "left" => {
          val selected = i.last.reverse
          val rest = i.dropRight(1)
          selected ++ readClockWiser(rest, "up")
        }
        case "up" => {
          val selected = i.reverse.flatMap(_.headOption)
          val rest = i.map(_.drop(1))
          selected ++ readClockWiser(rest)
        }
      }
    }

    readClockWiser(matrix).toList
  }
}
