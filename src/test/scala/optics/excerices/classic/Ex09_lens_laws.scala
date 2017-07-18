package optics.excerices.classic

import org.specs2.Specification
import org.specs2.cats.CatsEqMatcher

class LensLawsSpec extends Specification with CatsEqMatcher {
  override def is =
    s2"""
      An Lens must satisfy following properties:
        setting a field and than getting it back should return originally set field value $setting
        getting a field and then setting it back should return  the same field value $getting
        setting a field twice is the same as setting it once with last value. Last one wins $settingTwice

    """

  def setting = ???

  def getting = ???

  def settingTwice = ???

}
