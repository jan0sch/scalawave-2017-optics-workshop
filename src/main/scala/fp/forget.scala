package fp

final case class Forget[A, B, C](forget: B => A)

