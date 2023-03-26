package sierikov.leetcode.tasks.easy

object ReshapeTheMatrix {

  /**
    * Reshapes the matrix to the given number of rows and columns
    *
    * @param mat original matrix
    * @param r number of wanted rows
    * @param c number of wanted columns
    * @return reshaped matrix or original matrix if it is impossible to reshape
    * @see [[https://leetcode.com/problems/reshape-the-matrix/]]
    */
  def matrixReshape(mat: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
    if (r * c != mat.length * mat.head.length) return mat
    mat.flatten.grouped(c).toArray
  }
}
