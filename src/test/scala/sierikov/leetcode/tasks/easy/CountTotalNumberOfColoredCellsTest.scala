package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class CountTotalNumberOfColoredCellsTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    assert(CountTotalNumberOfColoredCells.coloredCells(1) == 1)
    assert(CountTotalNumberOfColoredCells.coloredCells(2) == 5)
    assert(CountTotalNumberOfColoredCells.coloredCells(3) == 13)
    assert(CountTotalNumberOfColoredCells.coloredCells(4) == 25)
    assert(CountTotalNumberOfColoredCells.coloredCells(5) == 41)
  }
}
