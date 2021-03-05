package example

object P01 {
  def last[T](list: List[T]): T = list match { // type parameter is
    case x :: Nil => x
    case x :: xs  => last(xs)
    case _        => sys.error("last isn't defined for empty list")

    // コンスはリストの先頭に要素をくっつける
    /**
     * scala> val a = 1::Nil
     * val a: List[Int] = List(1)
     *
     * scala> a
     * val res0: List[Int] = List(1)
     *
     * scala> val a2 = 2::a
     * val a2: List[Int] = List(2, 1)
     *
     * scala> val a3 = 3::a2
     * val a3: List[Int] = List(3, 2, 1)
     */

  }
}

