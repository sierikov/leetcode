package sierikov.leetcode.tasks.medium

// leeetcode: https://leetcode.com/problems/peak-index-in-a-mountain-array/
object PeakIndexInMountainArray {
  def peakIndexInMountainArray(arr: Array[Int]): Int = {
    // borders in which we are searching
    var start = 0;
    var end = arr.length - 1;

    // here we can check if array size is minimum 3 elements
    // in this task it is guaranted by constrains
    // in the case if arr.length = 1, middle will be 0,
    // and middle + 1 will fail

    // binary search moves start and end to each other
    // and cuts the range of the search in each itteration by 2
    while (start < end) {
      val middle = (start + end) / 2
      val pointA = arr(middle)
      val pointB = arr(middle + 1)

      println(s"start is $start and end is $end in ${arr.mkString(",")}")

      if (pointA < pointB) // increasing part
        start = middle + 1 // continue to search "right" part
      else
        end = middle // continue to search "left" part
    }

    // here we must have A(start) > A(end)
    // this means, that we have found beginning of decreasing trend
    start
  }
}
