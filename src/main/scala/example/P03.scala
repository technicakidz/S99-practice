package example

/** P03 (*) Find the Kth element of a list.
  * By convention, the first element in the list is element 0.
  * Example:
  * scala> nth(2, List(1, 1, 2, 3, 5, 8))
  * res0: Int = 2
  **/

object P03 {
    def nth[T](n:Int, list:List[T]): T = {
      list match {
        case x :: _ if n == 0 => x
        case _ :: hoge if n > 0 => nth(n - 1, hoge)
        case _ => sys.error("error")
      }
    }
