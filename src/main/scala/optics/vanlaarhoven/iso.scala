package optics
package vanlaarhoven

import fp.Profunctor
import fp.Functor
import fp.Const
import fp.Identity


import scala.language.higherKinds


trait Iso[S, A] {
  self =>
  def apply[P[_, _] : Profunctor, F[_] : Functor](f: P[A, F[A]]): (P[S, F[S]])

  def get(s: S): A = ???

  def reverseGet(a: A): S = ???

  def modify(f: A => A): S => S = ???

  def reverse: Iso[A, S] = ???

  def composeIso[C](other: Iso[A, C]): Iso[S, C] = ???

}

object Iso {
  def apply[S, A](_get: S => A, _reverseGet: A => S): Iso[S, A] = ???
}
