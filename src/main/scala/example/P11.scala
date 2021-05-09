package example

import scala.util.map
import P09.pack
import P04.length

/**
 * Modified run-length encoding.
 * Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
 * Example:
 * scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
 */

object P11 {
  def encodeModified(list: List[T]): List[T] = {
    map(pack(list)){ x =>
      length(x) match {
        case 1 => x.head
        case i => (i, x.head)
      }
    }
  }
}