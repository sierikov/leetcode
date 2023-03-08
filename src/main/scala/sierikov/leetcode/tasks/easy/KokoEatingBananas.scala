package sierikov.leetcode.tasks.easy

import scala.annotation.tailrec

object KokoEatingBananas {
  def minEatingSpeed(piles: Array[Int], h: Int): Int = {

    @tailrec
    def iterate(hours: Int, upper: Int = piles.max, lower: Int = 1): Int = {
      if (upper == lower) return upper

      val speed = calcMidpoint(upper, lower)
      val hourForSpeed = calcNeededHoursFor(piles, speed)

      println(s"speed: $speed, hourForSpeed: $hourForSpeed, hours: $hours, upper: $upper, lower: $lower")

      if (hourForSpeed <= hours ) iterate(hours, speed, lower)
      else iterate(hours, upper, speed + 1)


    }

    iterate(h)
  }

  private def calcMidpoint(upper: Int, lower: Int): Int = lower + (upper - lower) / 2

  private def calcNeededHoursFor(piles: Array[Int], speed: Int): Int = piles.foldLeft(0) {
    case (hours, pile) =>
      val bananas = pile.toDouble
      val hour = (bananas / speed).ceil
      hours + hour.toInt
  }
}
