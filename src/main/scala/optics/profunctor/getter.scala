package optics.profunctor

import fp.Forget

trait Getter[S, A] extends Fold[A, S, A]

object Getter {
  def apply[S, A](f: S => A): Getter[S, A] = ???
}



