package sierikov.leetcode.tasks.easy

object BestTimeToBuyAndSellStock {

  /** Calculates max profit from buying and selling stock in given array of prices
    * @param prices array of prices
    * @return max profit
    * @see [[https://leetcode.com/problems/best-time-to-buy-and-sell-stock/]]
    */
  def maxProfit(prices: Array[Int]): Int = mutable(prices)

  /**
    * Modified mutable Kadane's algorithm
    * Algorithm will find minimum price and calculate profit from it.
    * @note profit cannot be negative
    * @param input array of prices
    * @return max profit
    * @see [[https://en.wikipedia.org/wiki/Maximum_subarray_problem]]
    * @see [[MaximumSubarray]]
    */
  def mutable(input: Array[Int]): Int = {
    var min: Int = Int.MaxValue
    var profit: Int = 0

    for (value <- input) {
      min = Math.min(min, value)
      profit = Math.max(value - min, profit)
    }
    profit
  }
}
