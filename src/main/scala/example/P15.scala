package example

import Util.flatMap
import Util.copyN

object P15 {
  def duplicateN[T](n: Int, list: List[T]): List[T] = {
    flatMap(list) {case x => copyN(n, x)}
    }
  }
}