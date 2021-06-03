package example

/**
 * Decode a run-length encoded list.
 * Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
 * Example:
 * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
 * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 */

object P12 {
  def append[T](a: List[T], b: List[T]): List[T] =
  a match {
    case Nil     => b
    case x :: xs => x :: append(xs, b)
  }
  def foldLeft[A, B](list: List[A], b: B)(f: (B, A) => B): B = {
    list match {
      case x :: xs => foldLeft(xs, f(b, x))(f)
      case Nil     => b
    }
  }
  def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = {
    foldLeft(list, List[B]()) { (b, a) => append(b, f(a)) }
  }
  def copyN[T](t: T, n:Int): List[T] =
    n match {
      case 0          => List()
      case n if n > 0 => t :: copyN(t, n - 1)
      case _          => sys.error("")
    }

  def decode[T](encode: List[(Int, T)]): List[T] = {
    flatMap(encode){case (i, x) => copyN(x, i)}
  }
}