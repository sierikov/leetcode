package sierikov.leetcode.tasks.easy

object NumberOfZeroFilledSubarrays {
  def zeroFilledSubarray(nums: Array[Int]): Long = {
    if (!nums.contains(0)) return 0L

    (1 to nums.length).map(count0(nums, _)).filter(_ > 0).sum
  }
  private def count0(array: Array[Int], window: Int): Int = array
    .sliding(window)
    .map(_.forall(_ == 0))
    .count(_ == true)
}
