package sierikov.leetcode.tasks.medium

import sierikov.leetcode.tasks.easy.ConvertSortedListToBinarySearchTree.sortedListToBST

// leetcode: https://leetcode.com/problems/most-beautiful-item-for-each-query/
object MostBeautifulItemForEachQuery {
  def maximumBeauty(items: Array[Array[Int]], queries: Array[Int]): Array[Int] = {

    val sortedItems = items.sortBy(_.head) // sort by price
    var max = sortedItems(0)(1) // first beauty

    for (i <- sortedItems.indices) {
      max = math.max(max, sortedItems(i)(1))
      sortedItems(i)(1) = max
    }

    val ans = Array.ofDim[Int](queries.length)
    for (i <- queries.indices) {
      ans(i) = binarySearch(sortedItems, queries(i))
    }

    ans
  }

  private def binarySearch(items: Array[Array[Int]], targetPrice: Int): Int = {
    var l = 0
    var r = items.length - 1
    var maxBeauty = 0
    while (l <= r) {
      val mid = (l + r) / 2
      if (items(mid)(0) > targetPrice) {
        r = mid - 1
      } else {
        // Found viable price. Keep moving to right
        maxBeauty = math.max(maxBeauty, items(mid)(1))
        l = mid + 1
      }
    }
    maxBeauty
  }
}
