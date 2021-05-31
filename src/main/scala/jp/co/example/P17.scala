package jp.co.example

object P17 {
  def split[T](n: Int, list:List[T]): (List[T], List[T]) =
    list match {
        // 0 のときリストはそのまま返す
        // n = 1 のとき一つ目の要素を xs で返す
        // n = 2以上のとき先頭要素に n-1 目の要素を連結して返す
      case x :: xs if n == 0 => (List[T](), xs)
      case x :: xs if n > 0 =>
        split(n - 1, xs) match { case (a, b) => (x :: a, b) }
      case _ => sys.error("")
    }
}