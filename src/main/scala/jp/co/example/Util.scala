package jp.co.example

object Util {
  def map[A, B](list:List[A])(f:A => B):List[B] =
    list match {
      case x :: xs => f(x) :: map(xs)(f)
      case Nil => Nil
  }

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

  def flatMap[A, B](list: List[A])(f:A => List[B]):List[B] =
    foldLeft(list, List[B]()){
      (b, a) => append(b, f(a))
    }
}