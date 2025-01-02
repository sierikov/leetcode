package sierikov.leetcode.tasks.medium

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CountVowelStringsRangesTest extends AnyFlatSpec with Matchers {

  import CountVowelStringsRanges._

  it should "handle basic single-word case" in {
    val words = Array("aba", "bcb", "ece", "aa", "e")
    val queries = Array(Array(0, 2), Array(1, 4), Array(1, 1))
    vowelStrings(words, queries) shouldBe Array(2, 3, 0)
  }

  it should "handle stress test" in {
    val words = Array(
      "a",
      "rmivyakd",
      "kddwnexxssssnvrske",
      "vceguisunlxtldqenxiyfupvnsxdubcnaucpoi",
      "nzwdiataxfkbikbtsjvcbjxtr",
      "wlelgybcaakrxiutsmwnkuyanvcjczenuyaiy",
      "eueryyiayq",
      "bghegfwmwdoayakuzavnaucpur",
      "ukorsxjfkdojcxgjxgmxbghno",
      "pmgbiuzcwbsakwkyspeikpzhnyiqtqtfyephqhl",
      "gsjdpelkbsruooeffnvjwtsidzw",
      "ugeqzndjtogxjkmhkkczdpqzwcu",
      "ppngtecadjsirj",
      "rvfeoxunxaqezkrlr",
      "adkxoxycpinlmcvmq",
      "gfjhpxlzmokcmvhjcrbrpfakspscmju",
      "rgmzhaj",
      "ychktzwdhfuruhpvdjwfsqjhztshcxdey",
      "yifrzmmyzvfk",
      "mircixfzzobcficujgbj",
      "d",
      "pxcmwnqknyfkmafzbyajjildngccadudfziknos",
      "dxmlikjoivggmyasaktllgmfhqpyznc",
      "yqdbiiqexkemebyuitve"
    )
    val queries = Array(
      Array(0, 0),
      Array(5, 21),
      Array(17, 22),
      Array(19, 23),
      Array(13, 15),
      Array(20, 23),
      Array(21, 23),
      Array(6, 20),
      Array(1, 8),
      Array(15, 20),
      Array(17, 22),
      Array(6, 6),
      Array(1, 2),
      Array(4, 11),
      Array(14, 23),
      Array(7, 10),
      Array(16, 22),
      Array(20, 22),
      Array(21, 22),
      Array(15, 18),
      Array(5, 16),
      Array(17, 23)
    )
    vowelStrings(words, queries) shouldBe Array(1, 2, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 2, 0)
  }
}
