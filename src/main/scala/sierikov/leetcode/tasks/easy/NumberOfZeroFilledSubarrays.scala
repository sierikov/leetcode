package sierikov.leetcode.tasks.easy

object NumberOfZeroFilledSubarrays {
  def zeroFilledSubarray(nums: Array[Int]): Long = count0(nums)

  /** Calculates sum of all possible sub-arrays with `0`
    * Algorithm:
    * Iterating over array:
    * If current element is `0`, then add `1` to [[count]] and add count to accumulator ([[acc]])
    * otherwise reset [[count]] to `0`
    *
    * @example input: `Array(0, 2, 0, 0, 0, 3, 0)`
    *          {{{
    *            met 0 = (1, 1)
    *            met 2 = (0, 1)
    *            met 0 = (1, 2)
    *            met 0 = (2, 4)
    *            met 0 = (3, 7)
    *            met 3 = (0, 7)
    *            met 0 = (1, 8)
    *          }}}
    * @note Is written with `fold` to practice it
    * @param array with 0 or other integers
    * @return sum of all possible sub-arrays with 0
    * @see [[https://leetcode.com/problems/number-of-zero-filled-subarrays]]
    * @see [[https://leetcode.com/problems/number-of-zero-filled-subarrays/solutions/3324279/foldleft-explanation/]]
    */
  private def count0(array: Array[Int]): Long = array
    .foldLeft((0, 0): (Long, Long)) {
      case ((count, acc), 0) => (count + 1, acc + count + 1)
      case ((_, acc), _)     => (0, acc)
    }
    ._2

}
