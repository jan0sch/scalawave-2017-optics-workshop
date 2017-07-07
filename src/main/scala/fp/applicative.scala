package fp

import scala.language.higherKinds

trait Applicative[F[_]] extends Functor[F] {
  def pure[A](a: A): F[A]
}