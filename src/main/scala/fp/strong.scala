package fp

import scala.language.higherKinds

trait Strong[P[_, _]] extends Profunctor[P] {

  def first[A, B, C](fa: P[A, B]): P[(A, C), (B, C)]

  def second[A, B, C](fa: P[A, B]): P[(C, A), (C, B)]

}
