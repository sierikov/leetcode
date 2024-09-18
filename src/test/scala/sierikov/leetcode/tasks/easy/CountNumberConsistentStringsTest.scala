package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec

class CountNumberConsistentStringsTest extends AnyFlatSpec{

  import CountNumberConsistentStrings.*

  it should "pass example" in {
    assert(countConsistentStrings("ab", Array("ad","bd","aaab","baa","badab")) == 2)
    assert(countConsistentStrings("cad", Array("cc","acd","b","ba","bac","bad","ac","d")) == 4)
  }
}
