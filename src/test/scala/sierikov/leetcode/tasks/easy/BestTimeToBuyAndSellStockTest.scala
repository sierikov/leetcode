package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class BestTimeToBuyAndSellStockTest extends AnyFlatSpec {
  import BestTimeToBuyAndSellStock._

  it should "pass basic tests" in {
    assert(maxProfit(Array(7, 1, 5, 3, 6, 4)) == 5)
    assert(maxProfit(Array(7, 6, 4, 3, 1)) == 0)
  }

  it should "never buy and sell on the same day" in {
    assert(maxProfit(Array(1, 2)) == 1)
    assert(maxProfit(Array(2, 1)) == 0)
  }

  it should "never return negative profit" in {
    assert(maxProfit(Array(7, 4, 3, 2, 1)) == 0)
  }
}
