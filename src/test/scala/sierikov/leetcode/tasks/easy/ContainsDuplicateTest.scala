package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class ContainsDuplicateTest extends AnyFlatSpec {
  import ContainsDuplicate._
  it should "detect duplicates" in {
    assert(containsDuplicate(Array(1, 2, 3, 1)))
    assert(containsDuplicate(Array(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
    assert(!containsDuplicate(Array(1, 2, 3, 4)))
  }
}
