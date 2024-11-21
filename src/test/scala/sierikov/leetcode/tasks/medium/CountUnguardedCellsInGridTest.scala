package sierikov.leetcode.tasks.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CountUnguardedCellsInGridTest extends AnyFlatSpec with Matchers {

  import CountUnguardedCellsInGrid._

  it should "count unguarded cells correctly" in {
    val guards = Array(Array(0, 0), Array(1, 1), Array(2, 3))
    val walls = Array(Array(0, 1), Array(2, 2), Array(1, 4))

    countUnguarded(4, 6, guards, walls) shouldBe 7
  }

}
