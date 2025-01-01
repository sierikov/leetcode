package sierikov.leetcode.tasks.easy

object MaximumScoreAfterSplittingString extends App {

  def maxScore(s: String): Int = s.toList match
    case Nil      => 0
    case _ :: Nil => 1
    case c :: rest => {

      var lScore = if (c == '0') 1 else 0
      var rScore = rest.count(_ == '1')
      var max = lScore + rScore

      rest.init.foreach {
        case '0' =>
          lScore += 1
          max = math.max(max, lScore + rScore)
        case '1' =>
          if (rScore > 0) rScore -= 1
          max = math.max(max, lScore + rScore)
      }
      max
    }
}
