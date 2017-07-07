package fp

import scala.language.higherKinds

trait Choice[P[_, _]] extends Profunctor[P] {

  def left[A, B, C](f: P[A, B]): P[Either[A, C], Either[B, C]]

  def right[A, B, C](f: P[A, B]): P[Either[C, A], Either[C, B]]
}

