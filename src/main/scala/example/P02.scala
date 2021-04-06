package example

/**
 * P02 (*) Find the last but one element of a list.
 * Example:
 * scala> penultimate(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 5
 */

object P02 {
  def penultimate[T](list: List[T]):T = list match {
    case x :: _ :: Nil => x
    case _ :: y :: xs  => penultimate(y :: xs)
    case _        => sys.error("指定される条件の文字列がないかリストが空です")
  }
}
