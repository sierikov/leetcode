package sierikov.leetcode.tasks.easy

object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val zipped = nums.zipWithIndex
    val map = zipped.toMap
    zipped
      .find { case (num, index) =>
        map.get(target - num).exists(_ != index)
      }
      .map { case (num, index) =>
        Array(index, map(target - num))
      }
      .get
  }
}
