package sierikov.leetcode.tasks.medium

// leetcode: https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/
object TakeKOfEachCharacterFromLeftAndRight {

  def takeCharacters(s: String, k: Int): Int = {
    val stringSize = s.length
    val counts = s.foldLeft(LetterCount.apply())(_.increment(_))

    // check if we have enough occurrences
    if (counts.isNotValid(k)) return -1

    var windowCounts = LetterCount()
    var left = 0
    var maxWindow = 0

    // Find the longest window that leaves k of each character outside
    for (right <- s.indices) {
      windowCounts = windowCounts.increment(s(right))

      // Shrink window if we take too many characters
      while (
        left <= right &&
        LetterCount(
          counts.a - windowCounts.a,
          counts.b - windowCounts.b,
          counts.c - windowCounts.c
        ).isNotValid(k)
      ) {
        windowCounts = windowCounts.decrement(s(left))
        left += 1
      }

      maxWindow = Math.max(maxWindow, right - left + 1)
    }

    stringSize - maxWindow
  }

  case class LetterCount(a: Int = 0, b: Int = 0, c: Int = 0) {
    def increment(char: Char): LetterCount = char match
      case 'a' => copy(a = a + 1)
      case 'b' => copy(b = b + 1)
      case 'c' => copy(c = c + 1)
      case _   => throw IllegalStateException("Unexpected in the task letter")

    def decrement(char: Char): LetterCount = char match
      case 'a' => copy(a = a - 1)
      case 'b' => copy(b = b - 1)
      case 'c' => copy(c = c - 1)
      case _   => throw IllegalStateException("Unexpected in the task letter")

    def isValid(k: Int): Boolean = a >= k && b >= k && c >= k
    def isNotValid(k: Int): Boolean = !isValid(k)
  }
}
