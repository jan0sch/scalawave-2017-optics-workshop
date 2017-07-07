package optics.excerices.classic

import org.specs2.Specification
import org.specs2.cats.CatsEqMatcher

class OptionalLawsSpec extends Specification with CatsEqMatcher {
  def is =
    """
      An Optional must satisfy following property:
        - getOrModify a value A from S and then set it back in, the result is an object identical to the original one $test01
        - set a value, you always getOption the same value back $test02
    """

  def test01 = ???

  def test02 = ???



}
