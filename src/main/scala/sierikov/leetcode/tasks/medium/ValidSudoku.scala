package sierikov.leetcode.tasks.medium

object ValidSudoku {

  import scala.collection.immutable.HashSet

  /**
    * Checks if the board is valid.
    * The board is valid when it contains only unique numbers in each row, column and 3x3 sub-box.
    * Each row and column must contain the numbers 1-9 without repetition.
    *
    * @param board board to check
    * @return true if the board is valid
    * @see [[https://leetcode.com/problems/valid-sudoku]]
    */
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {

    /**
      * Checks if the sub-box is valid.
      * The sub-box is 3x3 square and is valid when it contains only unique numbers.
      * @param row - row of the top-left corner of the sub-box
      * @param column - column of the top-left corner of the sub-box
      * @return true if the sub-box is valid
      */
    def validSubBox(row: Int, column: Int): Boolean = {
      val numbers: Seq[Char] = for {
        row <- Seq(row, row + 1, row + 2)
        column <- Seq(column, column + 1, column + 2)
        if board(row)(column) != '.'
      } yield board(row)(column)

      numbers.groupBy(identity).forall(_._2.length == 1)
    }

    def row(k: Int): Array[Char] = board(k)
    def col(k: Int): Array[Char] = board.map { a => a(k) }

    val cols = board.head.length
    val rows = board.length

    def isValid(chars: Array[Char]): Boolean = {
      chars.filterNot(_ == '.').sorted.sameElements(chars.filterNot(_ == '.').distinct.sorted)
    }

    val rowsValid = (0 until rows).map(row).forall(isValid)
    val colsValid = (0 until cols).map(col).forall(isValid)

    val subBoxesValid: Boolean = (for {
      row <- Seq(0, 3, 6)
      column <- Seq(0, 3, 6)
    } yield validSubBox(row, column)).forall(identity)

    subBoxesValid && rowsValid && colsValid
  }
}
