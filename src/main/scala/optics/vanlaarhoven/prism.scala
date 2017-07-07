package optics
package vanlaarhoven

import fp.Applicative
import fp.Choice
import fp.Identity

import scala.language.higherKinds
import scala.util.Try

trait Prism[S, A] {
  def apply[P[_, _] : Choice, F[_] : Applicative](f: P[A, F[A]]): (P[S, F[S]])

  final def modify(f: A => A): S => S = ???

  final def getOption(s: S): Option[A] = ???
}


object Prism {
  def apply[S, A](_getOrModify: S => Either[S, A], _reverseGet: A => S): Prism[S, A] = ???
}