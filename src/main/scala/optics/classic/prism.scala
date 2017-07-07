package optics
package classic

abstract class Prism[S, A] extends APrism[S, A] {
  self =>

  def getOrModify(s: S): Either[S, A] = ???

  def getOption(s: S): Option[A]

  def reverseGet(a: A): S

  def set(a: A): S => S = ???

  final def modify(f: A => A): S => S = ???

  final def composePrism[C](other: Prism[A, C]): Prism[S, C] = ???
  /**
    * Compose with other optics
    */

  final def composeTraversal[C](other: Traversal[A, C]): Traversal[S, C] = ???

  final def composeOptional[C](other: Optional[A, C]): Optional[S, C] = ???

  final def composeIso[C](other: Iso[A, C]): Prism[S, C] = ???

  final def composeLens[C](other: Lens[A, C]): Optional[S, C] = ???

  /**
    * View as other optics
    */

  final def asTraversal: Traversal[S, A] = ???

  final def asOptional: Optional[S, A] = ???
}

object Prism {
  def apply[S, A](_getOption: S => Option[A])(_reverseGet: A => S): Prism[S, A] = new Prism[S, A] {

    override def getOption(s: S): Option[A] = _getOption(s)

    override def reverseGet(a: A): S = _reverseGet(a)

  }
}
