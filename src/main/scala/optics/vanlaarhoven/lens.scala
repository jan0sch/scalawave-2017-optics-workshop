package optics
package vanlaarhoven


import scala.language.higherKinds

import fp.Functor
import fp.Const
import fp.Identity

/**
  * type Lens s t a b = Functor f => (a -> f b) -> (s -> f t)
  *
  * type Lens s t => Functor f => (t -> f t) -> (s -> f s)
  */


trait Lens[S, T] extends ALens[S, T] {
  self =>

  def apply[F[_] : Functor](f: T => F[T]): (S => F[S])

  final def get(s: S): T = ???

  final def set(t: T): S => S = ???

  final def modify(f: T => T): S => S = ???

  final def composeLens[C](other: Lens[T, C]): Lens[S, C] = ???

}

object Lens {

  def apply[S, T](_get: S => T, _set: T => S => S): Lens[S, T] = ???

}
