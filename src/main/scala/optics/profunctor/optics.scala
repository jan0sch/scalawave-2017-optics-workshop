package optics
package profunctor


import scala.language.higherKinds


/**
  *
  * type Iso[P[_, _], S, T, A, B] = Optic[Profunctor, P, S, T, A, B]
  * type Lens[P[_, _], S, T, A, B] = Optic[Strong, P, S, T, A, B]
  * type Prism[P[_, _], S, T, A, B] = Optic[Choice, P, S, T, A, B]

  * type Fold[R, S, T, A, B] = Optic[Id, Forget[R, ?, ?], S, T, A, B]
  * type Getter[S, T, A, B] = Fold[A, S, T, A, B]
  * type Setter[P[_, _], S, T, A, B] = Optic[Func, P, S, T, A, B]
  *
  *
  * type Forget[R, A, B] = A => R
  *
  *
  *
  *
  * haskell / puresript
  *
  * type IsoP s a       = forall p. (Profunctor p) => p a a -> p s s
  * type LensP s a      = forall p. (Strong p) => p a a -> p s s
  * type PrismP s a     = forall p. (Choice p) => p a a -> p s s
  * type TraversalP s a = forall p. (Wander p) => p a a -> p s s
  * type FoldP r s a    = Forget r a a -> Forget r s s
  */
trait Optics[P[_[_, _]], ~>[_, _], S, A] {
  self =>
  def apply(p: P[~>])(pab: A ~> A): S ~> S
}














