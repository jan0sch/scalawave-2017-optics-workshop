package optics.excerices.classic

import optics.classic.Prism
import org.specs2.Specification
import org.specs2.cats.CatsEqMatcher

class PrismLawsSpec extends Specification with CatsEqMatcher {
  override def is =
    s2"""
      A Prism must satisfy following property: getOption and reverseGet allow a full round trip if the Prism matches
       forward $forward
       backward $backward


    """

  def forward = ???

  def backward = ???

  def prism[S, A]: Prism[S, A] = ???
}
