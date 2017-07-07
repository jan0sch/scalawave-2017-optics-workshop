package optics
package profunctor

import fp.Profunctor
import fp.Forget

import scala.language.higherKinds

trait Iso[~>[_, _], S, A] extends Optics[Profunctor, ~>, S, A]

object Iso {
  def apply[~>[_, _], S, A](_get: S => A, _reverseGet: A => S): Iso[~>, S, A] = ???
}