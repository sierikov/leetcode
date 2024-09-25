package sierikov.leetcode.tasks.medium

import scala.annotation.tailrec
import scala.collection.immutable.Queue

// Leetcode: https://leetcode.com/problems/course-schedule-ii/description/
object CourseSheduleII {
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    val map: Map[Int, Array[Int]] = createMap(prerequisites)
    val starting = Queue.apply(findStarting(numCourses, createMap(prerequisites)).toArray*)
    iterateOverCourses(map, starting)
  }

  def createMap(prerequisites: Array[Array[Int]]): Map[Int, Array[Int]] =
    prerequisites.groupMap(_.apply(0))(_.tail.head)

  def findStarting(n: Int, map: Map[Int, Array[Int]]): Set[Int] =
    (0 until n).filter(i => map.get(i).isEmpty).toSet

  @scala.annotation.tailrec
  def iterateOverCourses(
    map: Map[Int, Array[Int]],
    startingCourses: Queue[Int],
    takenCourses: Vector[Int] = Vector.empty
  ): Array[Int] = startingCourses.dequeueOption match
    case Some((course, queue)) => {
      val removedVertex = map.view.mapValues(_.filter(_ != course)).toMap
      val (coursesWithNoDependencies, otherCourses) = removedVertex.partition(_._2.isEmpty)
      iterateOverCourses(
        otherCourses,
        queue.enqueueAll(coursesWithNoDependencies.keySet),
        takenCourses :+ course
      )
    }
    case None if map.isEmpty => takenCourses.toArray
    case None                => Array.emptyIntArray
}
