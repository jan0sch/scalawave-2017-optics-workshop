package optics

trait AIso[S, A] {

  def get(s: S): A

  def reverseGet(t: A): S
}

trait APrism[S, A] {

  def getOption(s: S): Option[A]

  def reverseGet(t: A): S
}

trait ALens[S, A] {

  def get(s: S): A

  def set(t: A): S => S
}
