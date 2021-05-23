package jp.co.example

object P16 {
  def drop[T](n:Int, list:List[T]):List[T] = {
    def dropA(m:Int,list:List[T]):List[T] = list match {
      case x :: xs => if m == 1 dropA(n, xs)
      case x :: xs => if m > 1 x :: dropA(m -1, xs)
      case _ => List[T]() // ここで対象の要素を unit で返し drop する
    }
    if (n > 0) dropA(n, list) else sys.error("error")
//    if val tagret:List[Int] = list(n)
//    else sys.error("nothing element")
//    list match {
//      case x :: xs => ???
//    }
  }
}