package optics
package excerices.classic

import optics.classic.Optional
import org.specs2.Specification
import org.specs2.cats.CatsEqMatcher

class OptionalSpec extends Specification with CatsEqMatcher {
  def is =
    s2"""
        An Optional is an Optic used to zoom inside a Product, e.g. case class, Tuple, HList or even Map.
        Unlike the Lens, the element that the Optional focuses on may not exist.

        Write an Optional which will zoom from List[Int] to a potential head of list

        Once Lens is defined:
          - getOption on list should behave as ordinary headOption of list $test01 and $test02
          - getOrModify in addition should return original list $test04 otherwise head $test03
          - modifying Optional $test05
      """



  def test01 = secondElementOp.getOption(list) must beSome(1)
  def test02 = secondElementOp.getOption(emptyList) must beNone

  def test03 = secondElementOp.getOrModify(list) must beRight(1)
  def test04 = secondElementOp.getOrModify(emptyList) must beLeft(emptyList)


  def test05 = secondElementOp.modify(_ + 3)(list) must beEqualTo(List(4, 2, 3, 4))

  lazy val list: List[Int] = List(1, 2, 3, 4)
  lazy val emptyList: List[Int] = List.empty[Int]

  /**
    * TODO: Implement me
    *
    * Hint: Use the apply method from Optional
    *
    */
  lazy val secondElementOp: Optional[List[Int], Int] = ???
}
