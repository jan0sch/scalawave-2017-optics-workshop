package optics
package classic

abstract class Optional[S, A] { self =>

  def getOrModify(s: S): Either[S, A] = ???

  def getOption(s: S): Option[A]

  def set(a: A): S => S = ???

  final def modify(f: A => A): S => S = ???

  final def composeOptional[C](other: Optional[A, C]): Optional[S, C] = ???


  /**
    * Compose with other optics
    */

  final def composeTraversal[C](other: Traversal[A, C]): Optional[S, C] = ???

  final def composeIso[C](other: Iso[A, C]): Optional[S, C] = ???

  final def composePrism[C](other: Prism[A, C]): Optional[S, C] = ???

  final def composeLens[C](other: Lens[A, C]): Optional[S, C] = ???

  /**
    * View as other optics
    */

  final def asTraversal: Traversal[S, A] = ???

  final def asIso: Optional[S, A] = ???

  final def asPrism: Prism[S, A] = ???

  final def asLens: Lens[S, A] = ???
}

object Optional {
  def apply[S, A](_getOption: S => Option[A])(_set: A => S => S): Optional[S, A] = new Optional[S, A] {

    override def set(t: A): S => S = _set(t)

    override def getOption(s: S): Option[A] = _getOption(s)
  }
}