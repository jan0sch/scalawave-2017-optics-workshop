package optics.excerices.classic

import org.specs2.Specification
import org.specs2.cats.CatsEqMatcher


class IsoLawsSpec extends Specification with CatsEqMatcher  {
  override def is =
    """
      An Iso must satisfy following properties
        getting and reverse getting should return original value $forward
        reverse getting and getting should return original value $backward
    """

  def forward = ???

  def backward = ???
}
