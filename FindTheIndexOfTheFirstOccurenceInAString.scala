object Solution {
  def strStr(haystack: String, needle: String): Int = needle match {
    case "" => 0
    case _ => haystack
        .sliding(needle.length)
        .zipWithIndex
        .collectFirst({ case (`needle`, y) => y })
        .getOrElse(-1)
    }
}
