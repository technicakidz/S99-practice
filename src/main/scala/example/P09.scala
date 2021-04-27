package example

/**
 * Pack consecutive duplicates of list elements into sublists.
 * If a list contains repeated elements they should be placed in separate sublists.
 * Example:
 * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 */

object P09 {
  def pack[T](ls:List[T]):List[List[T]] = {
    def packA(a: List[T], b: List[T]): List[List[T]] = b match {
      case x :: xs if a.head == x => packA(x :: a, xs)
      case x :: xs => a :: packA(List(x), xs)
      case _ => a :: Nil
    }
    ls match {
      case x :: xs => packA(List(x), xs)
      case _ => Nil
    }
  }
}


// 模範解答
// https://github.com/scala-text/S99/blob/master/src/main/scala/jp/co/dwango/s99/P09.scala
//def pack[T](list: List[T]):List[List[T]] = {
//  list.foldRight(Nil: List[List[T]]) {
//  (s, List) => list match {
//  case (x @ `e` :: _) :: xs => (s :: x) :: xs
//  case _ => List(s) :: List
//  }
//  }
//  }

// example: foldRight
// Listの全ての要素を足し合わせるメソッドsumをfoldRightを用いて実装してみましょう。
// sumの宣言は次のようになります。なお、Listが空のときは0を返してみましょう。
// https://namu-r21.hatenablog.com/entry/2019/07/21/211121
//def sum(list: List[Int]): Int = list match {
//  case x :: xs => list.foldRight[Int](0)((x, y) => x+y)
//  case _ => 0
//  }
// または
// def sum(list: List[Int]): Int = list.foldRight(0){(x, y) => x + y}