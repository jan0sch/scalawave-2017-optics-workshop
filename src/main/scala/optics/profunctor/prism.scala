package optics
package profunctor

import fp.Choice

import scala.language.higherKinds

trait Prism[~>[_, _], S, A] extends Optics[Choice, ~>, S, A]

object Prism {
  def apply[~>[_, _], S, A](_getOrModify: S => Either[S, A], _reverseGet: A => S): Prism[~>, S, A] = ???
}

