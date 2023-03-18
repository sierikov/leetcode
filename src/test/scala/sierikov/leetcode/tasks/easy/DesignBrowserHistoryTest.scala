package sierikov.leetcode.tasks.easy

import org.scalatest.OneInstancePerTest
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual
import sierikov.leetcode.tasks.easy.DesignBrowserHistory.*

/**
 * The BrowserHistory object will be instantiated and called as such:
 * {{{
 * var obj = new BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 * }}}
 */
class DesignBrowserHistoryTest extends AnyFlatSpec with OneInstancePerTest {
  val browser = new BrowserHistory("leetcode.com")

  it should "pass basic tests" in {
    browser.visit("google.com")
    browser.visit("facebook.com")
    browser.visit("youtube.com")
    assert(browser.back(1) == "facebook.com")
    assert(browser.back(1) == "google.com")
    assert(browser.forward(2) == "youtube.com")
  }

  it should "reset forward history" in {
    browser.visit("google.com")
    browser.visit("facebook.com")
    browser.visit("youtube.com")
    assert(browser.back(1) == "facebook.com")
    assert(browser.back(1) == "google.com")
    browser.visit("linkedin.com")
    assert(browser.forward(2) == "linkedin.com")
  }

  // ["BrowserHistory","visit",       "visit",         "visit",        "back", "back", "forward","visit","forward","back","back"]
  // [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],    [1],    [1],      ["linkedin.com"],[2],[2],[7]]
  it should "pass leetcode case" in {
    browser.visit("google.com")
    browser.visit("facebook.com")
    browser.visit("youtube.com")
    val r1 = browser.back(1)
    val r2 = browser.back(1)
    val r3 = browser.forward(1)
    browser.visit("linkedin.com")
    val r4 = browser.forward(2)
    val r5 = browser.back(2)
    val r6 = browser.back(7)

    Array(r1, r2, r3, r4, r5, r6) shouldEqual
      Array("facebook.com", "google.com", "facebook.com", "linkedin.com", "google.com", "leetcode.com")
  }

  // [youtube.com, (>)facebook.com, google.com, leetcode.com]
  // browserHistory.visit("linkedin.com")
  // [(>)linkedin.com, facebook.com, google.com, leetcode.com]
}
