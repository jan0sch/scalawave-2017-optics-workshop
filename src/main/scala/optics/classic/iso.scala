package optics
package classic

import scala.language.higherKinds

abstract class Iso[S, A] extends AIso[S, A] {
  self =>

  def get(s: S): A

  def reverseGet(t: A): S

  def reverse: Iso[A, S] = Iso[A, S](reverseGet)(get)

  final def modify(f: A => A): S => S = s => reverseGet(f(get(s)))

  //For compatibility reason
  def set(a: A): S => S = modify(_ => a)

  /**
    * Compose with other iso
    */
  final def composeIso[C](other: Iso[A, C]): Iso[S, C] = Iso[S, C](s => other.get(self.get(s)))(t => self.reverseGet(other.reverseGet(t)))
  /**
    * Compose with other optics
    */

  final def composeTraversal[C](other: Traversal[A, C]): Traversal[S, C] = ???


  final def composeOptional[C](other: Optional[A, C]): Optional[S, C] = ???

  final def composePrism[C](other: Prism[A, C]): Prism[S, C] = ???

  final def composeLens[C](other: Lens[A, C]): Lens[S, C] = ???

  /**
    * View as other optics
    */

  final def asTraversal: Traversal[S, A] = new Traversal[S, A] {
    override def modifyF[F[_] : scalaz.Applicative](f: (A) => F[A])(s: S): F[S] = ??? // self.modifyF(f)(s)
  }

  final def asOptional: Optional[S, A] = ???

  final def asPrism: Prism[S, A] = ???

  final def asLens: Lens[S, A] = ???

}

object Iso {
  def apply[S, T](_get: S => T)(_reverseGet: T => S): Iso[S, T] =
    new Iso[S, T] { st =>
      def get(s: S): T = _get(s)

      def reverseGet(t: T): S = _reverseGet(t)
    }
}
