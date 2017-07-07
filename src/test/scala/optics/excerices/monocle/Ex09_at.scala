package optics
package excerices.monocle

import monocle._
import monocle.function.all._
import monocle.syntax.all._
import monocle.macros.GenLens
import monocle.macros.Lenses
import monocle.macros.Lenses
import monocle.macros.Lenses
import monocle.macros.Lenses
import monocle.syntax.ApplyTraversal
import org.specs2.Specification

class AtSpec extends Specification {

  def is =
    s2"""

      Given
        Map(
          "red" -> List(
            (Pos(X(1), Y(1)), MS(1.0))),
          "blue" -> List(
            (Pos(X(0), Y(0)), MS(1.0)),
            (Pos(X(0), Y(1)), MS(2.0))),
          "white" -> List(
            (Pos(X(3), Y(1)), MS(1.0)),
            (Pos(X(4), Y(1)), MS(2.0)),
            (Pos(X(5), Y(0)), MS(3.0)),
            (Pos(X(5), Y(1)), MS(4.0))
          )
        )

      Remove all blue balls $test01
      Add new color $test02
      Add new red ball $test03

      Modify at $modifyAt

    """



  def test01 = ko("implement me")

  def test02 = ko("implement me")

  def test03 = ko("implement me")

  def modifyAt = ko("implement me")


}
