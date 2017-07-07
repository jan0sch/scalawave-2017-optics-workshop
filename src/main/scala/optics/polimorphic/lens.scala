package optics.polimorphic

abstract class PLens[S, T, A, B] {

  def get(a: A): S
  def set(b: B): S => T

}

trait Lens[S, A] extends PLens[S, S, A, A]


