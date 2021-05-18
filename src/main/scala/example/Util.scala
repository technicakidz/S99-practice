package example

object Util {
  def map[A, B](list:List[A])(f:A => B):List[B] =
    list match {
      case x :: xs => f(x) :: map(xs)(f)
      case Nil => Nil
  }
}