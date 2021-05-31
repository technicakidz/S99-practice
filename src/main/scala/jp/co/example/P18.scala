package jp.co.example

object P18 {
  def slice[T](n: Int, m: Int, list: List[T]): List[T] = {
    def sliceA(n:Int, m:Int, list:List[T]): List[T] = list match {
      case x :: xs if n > 0 => slice(n - 1, m - 1, xs) // 先頭の要素を順にはがして対象の先頭になる要素を取得
      case x :: xs if m > 0 => x :: slice(0, m - 1, xs) // ???
      case _ if n == 0 => List[T]() // 第一引数が0のとき対象はそのまま返す
      case _ => sys.error("")
    }
    if (0 <= n && 0 <= m) sliceA(n, m, list) else sys.error("") // ns >= 0 && ms >= 0 はだめらしい
  }
}