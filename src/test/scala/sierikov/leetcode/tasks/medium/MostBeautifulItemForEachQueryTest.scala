package sierikov.leetcode.tasks.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MostBeautifulItemForEachQueryTest extends AnyFlatSpec with Matchers {
  import MostBeautifulItemForEachQuery._

  it should "find query correctly" in {
    val items = Array(Array(1, 2), Array(3, 2), Array(2, 4), Array(5, 6), Array(3, 5))
    val queries = Array(1, 2, 3, 4, 5, 6)

    maximumBeauty(items, queries) shouldBe Array(2, 4, 5, 5, 6, 6)
  }

}
