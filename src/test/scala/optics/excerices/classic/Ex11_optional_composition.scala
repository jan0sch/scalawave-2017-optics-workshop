package optics
package excerices.classic

import optics.classic.Optional
import org.specs2.Specification
import org.specs2.cats.CatsEqMatcher

class OptionalCompositionSpec extends Specification with CatsEqMatcher {
  def is =
    s2"""
        Compose two optionals.
        Write test which will update user's email
      """


  sealed trait UserLike

  final case class User() extends UserLike

  final case class RegisteredUser(email: String) extends UserLike


  val users: List[UserLike] = List(RegisteredUser("user@example.com"), User())

  val listOp: Optional[List[UserLike], UserLike]  = ???

  val user: Optional[UserLike, String] = ???

  val composed: Optional[List[UserLike], String] = ???

}
