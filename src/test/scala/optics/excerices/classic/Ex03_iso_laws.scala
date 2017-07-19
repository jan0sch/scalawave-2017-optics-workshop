package optics.excerices.classic

import optics.classic.Iso
import optics.{KMH, MPH, MS}
import org.specs2.Specification
import org.specs2.cats.CatsEqMatcher


class IsoLawsSpec extends Specification with CatsEqMatcher  {
  override def is =
    s2"""
      An Iso must satisfy following properties
        getting and reverse getting should return original value $forward
        reverse getting and getting should return original value $backward
    """

  val iso = Iso[String, Array[Char]](_.toCharArray)(_.mkString)

  def forward = {
    val law: String => Boolean = s => iso.reverseGet(iso.get(s)) === s

    law("optics") === true
  }

  def backward = {
    val law: Array[Char] => Boolean = a => iso.get(iso.reverseGet(a)) === a

    law("optics".toCharArray) === true
  }

}
