package sierikov.leetcode.tasks.hard

import org.scalatest.flatspec.AnyFlatSpec

class CountVowelsPermutationTest extends AnyFlatSpec {

  import CountVowelsPermutation._

  it should "pass example" in {
    assert(countVowelPermutation(2) == 10)
    assert(countVowelPermutation(3) == 19)
  }

}
