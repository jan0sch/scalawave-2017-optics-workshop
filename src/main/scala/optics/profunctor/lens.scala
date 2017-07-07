package optics
package profunctor

import fp.Strong

import scala.language.higherKinds

trait Lens[S, A] extends Optics[Strong, Function1, S, A]

object Lens {
  def apply[S, A](_get: S => A, _set: A => S => S): Lens[S, A] = ???
}
