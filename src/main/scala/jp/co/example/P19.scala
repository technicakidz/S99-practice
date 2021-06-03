package jp.co.example

import P05.reverse
import Util.append

object P19 {
  // TODO: まず方針をたてて
  // 変数名を定義
  // 与えられるnにマイナスを考慮しないと仮定してコードを組む
  def rotate[T](n:Int, list:List[T]):List[T] = {
    def rotateA(m: Int, target1: List[T], target2:List[T]):List[T] = m match {
    case n if n > 0 => ???
    case n if n < 0 => ???
    case 0 => append(???, reverse(???))
  }
    list match {
      case Nil => sys.error("")
      case _ => rotateA(n, Nil, list)
    }
  }
}
