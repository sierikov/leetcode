package sierikov.leetcode.tasks.easy

import scala.collection.mutable.ArrayBuffer

object DesignBrowserHistory {

  /**
   * Represents a browser history
   *
   * @param _homepage - the homepage of the browser
   */
  class BrowserHistory(_homepage: String) {
    private val history = ArrayBuffer(_homepage) ++ ArrayBuffer.fill(4999)(null)
    private var current = 0
    private var right = 0

    /**
     * Add a new url to the history
     * @note increases the current pointer
     * @note the url is added to the history and the right pointer is set to the end of the history,
     *       so the "forward" history is reset.
     * @param url the url to visit
     */
    def visit(url: String): Unit = {
      println("visit")
      current += 1
      history.update(current, url)
      right = current
    }

    /**
     * Go back in the history
     * @note sets the current pointer to target position or 0
     * @param steps the number of steps to go back
     * @return the url of the page
     */
    def back(steps: Int): String = {
      current = Math.max(current - steps, 0)
      history(current)
    }

    /**
     * Go forward in the history
     * @note sets the right pointer to target position or the end of the history
     * @param steps the number of steps to go forward
     * @return the url of the page
     */
    def forward(steps: Int): String = {
      current = Math.min(current + steps, right)
      history(current)
    }

  }
}
