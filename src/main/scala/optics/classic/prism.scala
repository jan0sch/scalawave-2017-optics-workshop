package optics
package classic

abstract class Prism[S, A] extends APrism[S, A] {
  self =>

  def getOrModify(s: S): Either[S, A] = getOption(s) match {
    case None => Left(s)
    case Some(a) => Right(a)
  }


  def getOption(s: S): Option[A]

  def reverseGet(a: A): S

  def set(a: A): S => S = modify(_ => a)

  final def modify(f: A => A): S => S = s => getOption(s).map(a => reverseGet(f(a))).getOrElse(s)

  final def modifyOption(f: A => A): S => Option[S] = s => getOption(s).map(a => reverseGet(f(a)))

  final def composePrism[C](other: Prism[A, C]): Prism[S, C] = new Prism[S, C] {

    override def getOption(s: S): Option[C] = for {
      o <- self.getOption(s)
      p <- other.getOption(o)
    } yield p

    override def reverseGet(a: C): S = self.reverseGet(other.reverseGet(a))
  }

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
