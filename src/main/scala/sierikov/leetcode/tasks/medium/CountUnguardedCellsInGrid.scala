package sierikov.leetcode.tasks.medium

object CountUnguardedCellsInGrid {
  private enum Cell:
    case Unguarded, Guarded, Guard, Wall

  import Cell._

  private def markGuarded(row: Int, col: Int, grid: Array[Array[Cell]]): Unit = {
    def markDirection(directionRow: Int, directionCol: Int): Unit = {
      var r = row + directionRow
      var c = col + directionCol
      val totalRows = grid.length
      val totalColumns = grid.head.length
      while (
        r >= 0 && r < totalRows &&
        c >= 0 && c < totalColumns &&
        grid(r)(c) != Wall &&
        grid(r)(c) != Guard
      ) {
        if (grid(r)(c) == Unguarded) {
          grid(r)(c) = Guarded
        } else {
          r += directionRow
          c += directionCol
        }
      }
    }
    markDirection(-1, 0) // Up
    markDirection(1, 0) // Down
    markDirection(0, -1) // Left
    markDirection(0, 1) // Right
  }

  def countUnguarded(m: Int, n: Int, guards: Array[Array[Int]], walls: Array[Array[Int]]): Int = {
    val grid = Array.fill(m, n)(Unguarded)

    // Mark guards' positions
    for (guard <- guards) grid(guard(0))(guard(1)) = Guard

    // Mark walls' positions
    for (wall <- walls) grid(wall(0))(wall(1)) = Wall

    // Mark cells as guarded by traversing from each guard
    for (guard <- guards) markGuarded(guard(0), guard(1), grid)

    // Count unguarded cells
    grid.flatten.count(_ == Unguarded)
  }
}
