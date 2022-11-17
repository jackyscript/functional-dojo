/** This is a very simple implementation of a monad. To turn our functor into a
  * monad we just add the flatMap function.
  *
  * @param value
  *   Value of type the generic type A
  * @return
  *   a new Monad instance with the value determined by the given value.
  */
class Monad[A] private (val value: A) extends IsMonad[A]:
  override def toString = s"Monad(${value})"
  override def map[B](fn: A => B): IsMonad[B] = new Monad[B](fn(value))
  def flatMap[B](fn: A => B): B = (fn(value))
  override def inspect: Unit = println(toString)

/** Factory to create Monad instances */
object Monad:
  // def apply[A](value: A) = new Functor[A](value) // -> Functor[String] = Functor("save the "of" by implementing apply")
  def of[A](value: A) = new Monad[A](value)

/** Specifies what makes a monad */
trait IsMonad[A] extends IsFunctor[A]:
  def flatMap[B](fn: A => B): B
