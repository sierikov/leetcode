object Solution {
    def countBits(n: Int): Array[Int] = {
        (0 to n)
          .map(_.toBinaryString)
          .map(_.count(_ == '1'))
          .toArray
    }
}
