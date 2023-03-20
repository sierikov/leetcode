package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class CanPlaceFlowersTest extends AnyFlatSpec {
  import sierikov.leetcode.tasks.easy.CanPlaceFlowers.*
  it should "pass basic tests" in {
    assert(canPlaceFlowers(Array(1, 0, 0, 0, 1), 1))
    assert(!canPlaceFlowers(Array(1, 0, 0, 0, 1), 2))
  }

  it should "pass test case from discussion" in {
    assert(canPlaceFlowers(Array(0, 0, 1, 0, 0), 1))
    assert(canPlaceFlowers(Array(0, 0, 1, 0, 0), 2))
    assert(!canPlaceFlowers(Array(1, 0, 0, 0, 0, 1), 2))
  }

  it should "pass stress test" in {
    val arr = Array.fill(20000)(0)
    assert(canPlaceFlowers(arr, 10000))
  }

}
