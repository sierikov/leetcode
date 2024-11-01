package sierikov.leetcode.tasks.easy

import org.scalatest.flatspec.AnyFlatSpec
import sierikov.leetcode.tasks.easy.DeleteCharactersMakeFancyString.makeFancyString

class DeleteCharactersMakeFancyStringTest extends AnyFlatSpec {
  import DeleteCharactersMakeFancyString._

  it should "pass basic tests" in {
    assert(makeFancyString("s") == "s")
    assert(makeFancyString("ss") == "ss")
    assert(makeFancyString("leeetcode") == "leetcode")
    assert(makeFancyString("aaabaaaa") == "aabaa")
  }
}
