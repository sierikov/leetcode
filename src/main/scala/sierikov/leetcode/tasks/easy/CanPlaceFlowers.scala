package sierikov.leetcode.tasks.easy

object CanPlaceFlowers {

  /** Calculates if n flowers can be planted in flowerbed
    *
    * Algorithm:
    * 1. Add 0 to the beginning and to the end of flowerbed
    * 2. Sliding window of size 3 with step 1
    * 3. Count number of windows where all elements are 0 -> we can plant a flower there
    *    -> possible position ([[avaliablePositions]])
    * 4. Then take sliding window of possible positions of size 2 with step 2.
    * 5. if we have two possible positions in a row, we can plant only one flower
    *    -> reduce each pair of positions to true or false ([[reducePositions]]])
    * 6. if number of reduced position is greater or equal to n, we can plant n flowers
    *
    * @see [[https://leetcode.com/problems/can-place-flowers/]]
    * @param flowerbed current positions of flowers as an array
    * @param n number of flowers to be planted
    * @return if n flowers can be planted in flowerbed
    */
  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    val a = (0 :: flowerbed.toList) :+ 0
    val availablePositions = a.sliding(3, 1).map(_.forall(_ == 0))
    val reducedPositions = availablePositions.sliding(2, 2).map(_.reduce(_ || _))
    reducedPositions.count(_ == true) >= n
  }

}
