package jp.co.example

import scala.annotation.tailrec

/**
 * Reverse a list.
 * Example:
 * scala> reverse(List(1, 1, 2, 3, 5, 8))
 * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */
object P05 {
  def foldLeft[A, B](list: List[A], b: B)(f: (B, A) => B): B = {
    list match {
      case x :: xs => foldLeft(xs, f(b, x))(f)
      case Nil => b
    }
  }
  def reverse[T](list:List[T]): List[T] = {
    foldLeft(list, List[T]()){(b, a) => a::b}
  }
}

// 末尾再帰のアノテーション @tailrec を利用した解答例があった
//object P05 {
//  def reverse[T](list: List[T]): List[T] = {
//    @tailrec
//    def go(rem: List[T], acc: List[T]): List[T] =
//      rem match {
//        case Nil     => acc
//        case x :: xs => go(xs, x :: acc)
//      }
//    go(list, Nil)
//  }
//}

// 末尾再帰とは
// 関数aが他関数を呼び出すとき最後(末尾)に呼ばれるもの
// 以下でいうと関数c, dが末尾再帰となる
//def a() {
//  if b() {
//  c()
//  } else {
//  d()
//  }
//}