package sierikov.leetcode.tasks.hard

// Leetcode: https://leetcode.com/problems/count-vowels-permutation/description/
object CountVowelsPermutation {

  case class VowelsState(a: Long = 1, e: Long = 1, i: Long = 1, o: Long = 1, u: Long = 1) {
    private def mod(num: Long): Long = num % 1000000007

    def nextMod: VowelsState = VowelsState(
      a = mod(e), // after a can only be e
      e = mod(a + i), // after e can be a or i
      i = mod(a + e + o + u),  // after i can be any but i
      o = mod(i + u), // after o can be i or u
      u = mod(a) // after u can be only a
    )

    def sumMod: Long = mod(a + e + i + o + u)
  }

  def countVowelPermutation(n: Int): Int = helper(n, VowelsState())

  @scala.annotation.tailrec
  private def helper(i: Int, state: VowelsState): Int = i match
    case 1 => state.sumMod.toInt
    case _ => helper(i - 1, state.nextMod)
}
