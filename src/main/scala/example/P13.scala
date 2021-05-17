package example

/**Run-length encoding of a list (direct solution).
 * Implement the so-called run-length encoding data compression method directly.
 * I.e. don't use other methods you've written (like P09's pack); do all the work directly.
 * Example:
 * scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 */

object P13 {
  def encodeDirect[T](list:List[T]):List[(Int, T)] = {
        def encodeDirectA(a: T, n:Int, tmp:List[T]):List[(Int, T)] = {
          tmp match {
            case x :: xs if a == x => encodeDirectA(x, n + 1, xs)
            case x :: xs => (n, a) :: encodeDirectA(x, 1, xs)
            case _ => List((n, a))
          }
        }
    list match {
      case x :: xs => encodeDirectA(x, 1, xs)
      case _ => List()
    }
  }
}