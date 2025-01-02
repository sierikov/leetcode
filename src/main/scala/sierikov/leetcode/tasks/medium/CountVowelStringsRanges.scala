package sierikov.leetcode.tasks.medium

object CountVowelStringsRanges {

  def vowelStrings(words: Array[String], queries: Array[Array[Int]]): Array[Int] =
    val vowels = Set('a', 'o', 'e', 'u', 'i')
    val prefixCount = words.scanLeft(0) { (count, word) =>
      if (vowels.contains(word.head) && vowels.contains(word.last)) count + 1
      else count
    }
    queries.map {
      case Array(l, r) => prefixCount(r + 1) - prefixCount(l)
    }
}
