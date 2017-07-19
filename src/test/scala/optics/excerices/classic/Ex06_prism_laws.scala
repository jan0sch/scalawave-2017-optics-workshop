package optics.excerices.classic

import optics.classic.Prism
import org.specs2.Specification
import org.specs2.cats.CatsEqMatcher

import scala.util.Try

class PrismLawsSpec extends Specification with CatsEqMatcher {
  override def is =
    s2"""
      A Prism must satisfy following property: getOption and reverseGet allow a full round trip if the Prism matches
       forward $forward
       backward $backward


    """

  def forward = {
    val law: Double => Boolean = s => prism.getOption(prism.reverseGet(s)) === Some(s)
    law(3.0)
  }

  def backward = {
    val law: String => Boolean = s => prism.getOption(s) match {
      case None => true
      case Some(d) => prism.reverseGet(d) === s
    }
    law("3.0")
  }

  def prism: Prism[String, Double] = Prism[String, Double](s => Try(s.toDouble).toOption)(d => d.toString)
}
