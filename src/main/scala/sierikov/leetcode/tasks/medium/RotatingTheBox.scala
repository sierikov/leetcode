package sierikov.leetcode.tasks.medium

object RotatingTheBox {
  def rotateTheBox(box: Array[Array[Char]]): Array[Array[Char]] = {
    val m = box.length
    val n = box(0).length

    // Rotate the box 90 degrees clockwise
    val rotated = transpose(box).map(_.reverse)

    // Apply gravity to each column in the rotated box
    for (j <- 0 until m) {
      var emptySlot = n - 1
      var i = n - 1
      while (i >= 0) {
        rotated(i)(j) match {
          case '*' =>
            emptySlot = i - 1
          case '#' =>
            if (emptySlot != i) {
              rotated(emptySlot)(j) = '#'
              rotated(i)(j) = '.'
            }
            emptySlot -= 1
          case '.' => // Do nothing
        }
        i -= 1
      }
    }

    rotated
  }

  // Helper function to transpose a 2D array
  private def transpose(matrix: Array[Array[Char]]): Array[Array[Char]] = {
    if (matrix.isEmpty || matrix(0).isEmpty) Array.empty[Array[Char]]
    else {
      val rows = matrix.length
      val cols = matrix(0).length
      Array.tabulate(cols, rows)((i, j) => matrix(j)(i))
    }
  }
}
