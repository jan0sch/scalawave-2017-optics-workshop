package optics.profunctor

//type Setter s t a b = Optic Function s t a b
//over :: forall s t a b. Setter s t a b -> (a -> b) -> s -> t
//over l = l
trait Setter[S, A] extends Optics[Id, Function1, S, A]

object Setter {
  def apply[S, A](_modify: (S, A => A) => S) = ???
}