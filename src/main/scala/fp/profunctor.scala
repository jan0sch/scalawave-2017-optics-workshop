package fp

import scala.language.higherKinds


trait Profunctor[P[_, _]] {
  def dimap[A, B, C, D](pab: P[A, B])(f: C => A, g: B => D): P[C, D]
}