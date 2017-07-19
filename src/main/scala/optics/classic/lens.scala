package optics
package classic

abstract class Lens[S, A] extends ALens[S, A] {self =>

  def get(s: S): A

  def set(a: A): S => S

	def modify(f: A => A): S => S = s => set(f(get(s)))(s)

  def composeLens[C](other: Lens[A, C]): Lens[S, C] = new Lens[S, C] {
		override def get(s: S): C = other.get(self.get(s))
		
		override def set(a: C): (S) => S = s => self.modify(other.set(a))(s)
	}

  /**
    * Compose with other optics
    */

  final def composeTraversal[C](other: Traversal[A, C]): Traversal[S, C] =  ???

  final def composeOptional[C](other: Optional[A, C]): Optional[S, C] = ???

  final def composePrism[C](other: Prism[A, C]): Optional[S, C] = ???

  final def composeIso[C](other: Iso[A, C]): Lens[S, C] = ???

  /**
    * View as other optics
    */

  final def asTraversal: Traversal[S, A] = ???

  final def asOptional: Optional[S, A] = ???

}

object Lens {
  def apply[S, T](_get: S => T)(_set: T => S => S): Lens[S, T] = new Lens[S, T] {

    def get(s: S): T = _get(s)

    def set(t: T): S => S = s => _set(t)(s)
  }
}
