package optics
package profunctor

import fp.Forget

import scala.language.higherKinds

final case class Id[P[_, _]]()

trait Fold[R, S, A] extends Optics[Id, Forget[R, ?, ?], S, A]