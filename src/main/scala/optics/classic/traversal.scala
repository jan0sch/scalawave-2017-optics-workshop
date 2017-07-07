package optics.classic

import scala.language.higherKinds

abstract class Traversal[S, A] {
  self =>

  def modifyF[F[_] : scalaz.Applicative](f: A => F[A])(s: S): F[S]

  final def foldMap[M: scalaz.Monoid](f: A => M)(s: S): M =
    modifyF[scalaz.Const[M, ?]](a => scalaz.Const(f(a)))(s).getConst

  final def modify(f: A => A): S => S =
    modifyF[scalaz.Id.Id](f)

  final def set(a: A): S => S =
    modify(_ => a)


  final def composeTraversal[C](other: Traversal[A, C]): Traversal[S, C] = new Traversal[S, C] {
    def modifyF[F[_] : scalaz.Applicative](f: C => F[C])(s: S): F[S] =
      self.modifyF(other.modifyF(f)(_))(s)
  }

  /**
    * Compose with other optics
    */

  final def composeIso[C](other: Traversal[A, C]): Traversal[S, C] = ???

  final def composeOptional[C](other: Optional[A, C]): Traversal[S, C] = ???

  final def composePrism[C](other: Prism[A, C]): Traversal[S, C] = ???

  final def composeLens[C](other: Lens[A, C]): Traversal[S, C] = ???
}

object Traversal {
  def fromTraverse[T[_] : scalaz.Traverse, A]: Traversal[T[A], A] =
    new Traversal[T[A], A] {
      def modifyF[F[_] : scalaz.Applicative](f: A => F[A])(s: T[A]): F[T[A]] =
        scalaz.Traverse[T].traverse(s)(f)
    }

  def apply2[S, A](get1: S => A, get2: S => A)(_set: (A, A, S) => S): Traversal[S, A] =
    new Traversal[S, A] {
      def modifyF[F[_] : scalaz.Applicative](f: A => F[A])(s: S): F[S] =
        scalaz.Applicative[F].apply2(f(get1(s)), f(get2(s)))(_set(_, _, s))
    }

}
