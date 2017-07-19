package optics
package excerices.monocle

import monocle._
import monocle.function.all._
import monocle.syntax.all._
import monocle.macros.GenLens
import monocle.macros.Lenses
import monocle.syntax.ApplyTraversal
import org.specs2.Specification

import monocle.function.At.at // to get at Lens
import monocle.std.map._      // to get Map instance for At

class AtSpec extends Specification {

	def is =
	s2"""

	Given
	Map(
		"red" -> List(
			Ball(Pos(X(1), Y(1)), MS(1.0))),
		"blue" -> List(
			Ball(Pos(X(0), Y(0)), MS(1.0)),
			Ball(Pos(X(0), Y(1)), MS(2.0))),
		"white" -> List(
			Ball(Pos(X(3), Y(1)), MS(1.0)),
			Ball(Pos(X(4), Y(1)), MS(2.0)),
			Ball(Pos(X(5), Y(0)), MS(3.0)),
			Ball(Pos(X(5), Y(1)), MS(4.0))
		)
)

			Remove all blue balls $test01
			Add new color $test02
			Add new red ball $test03

			Modify at $modifyAt

			"""



			@Lenses("_") final case class Ball(pos: Pos, v: MS)
			@Lenses("_") final case class X(x: Int)
			@Lenses("_") final case class Y(y: Int)
			@Lenses("_") final case class Pos(x: X, y: Y)

			val balls = Map(
				"red" -> List(
					Ball(Pos(X(1), Y(1)), MS(1.0))),
				"blue" -> List(
					Ball(Pos(X(0), Y(0)), MS(1.0)),
					Ball(Pos(X(0), Y(1)), MS(2.0))),
				"white" -> List(
					Ball(Pos(X(3), Y(1)), MS(1.0)),
					Ball(Pos(X(4), Y(1)), MS(2.0)),
					Ball(Pos(X(5), Y(0)), MS(3.0)),
					Ball(Pos(X(5), Y(1)), MS(4.0))
				)
		)

	// Remove all blue balls.
	def test01 = {
		val remove: Map[String, List[Ball]] => String => Map[String, List[Ball]] = bs => colour => {
			bs applyLens at(colour)
		}.set(None)

		remove(balls)("blue") shouldEqual balls.filterNot(_._1 == "blue")
	}

  // Add a new colour
	def test02 = {
		val addColour: Map[String, List[Ball]] => String => Map[String, List[Ball]] = bs => colour => {
		  bs applyLens at(colour)
		}.set(Some(List.empty))
    addColour(balls)("green") shouldEqual balls + ("green" -> List.empty)
	}

// Create a new red ball
def test03 = {
    val addRedBall: Map[String, List[Ball]] => Ball => Map[String, List[Ball]] = bs => b => {
		      bs applyLens at("red") composeTraversal each
		    }.modify(xs => xs :+ b)
		 
		    addRedBall(balls)(Ball(Pos(X(6), Y(2)), MS(5.0))) shouldEqual Map(
			      "red" -> List(
				        Ball(Pos(X(1), Y(1)), MS(1.0)),
				        Ball(Pos(X(6), Y(2)), MS(5.0))
				      ),
			      "blue" -> List(
				        Ball(Pos(X(0), Y(0)), MS(1.0)),
				        Ball(Pos(X(0), Y(1)), MS(2.0))),
			      "white" -> List(
				        Ball(Pos(X(3), Y(1)), MS(1.0)),
				        Ball(Pos(X(4), Y(1)), MS(2.0)),
				        Ball(Pos(X(5), Y(0)), MS(3.0)),
				        Ball(Pos(X(5), Y(1)), MS(4.0))
				      ))
			 }

	def modifyAt = ko("implement me")


}
