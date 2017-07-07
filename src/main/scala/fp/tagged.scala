package fp

case class Tagged[S, B](untagged: B) {
  def retag[T]: Tagged[T, B] = Tagged(untagged)
}
