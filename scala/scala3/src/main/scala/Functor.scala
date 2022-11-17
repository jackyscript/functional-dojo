/** This is a very simple implementation of a functor. It simply has a
  * "of"-function that accepts a value and returns an object that has "map".
  *
  * @param value
  *   Value of type the generic type A
  * @return
  *   a new Functor instance with the value determined by the given value.
  */
class Functor[A] private (val value: A) extends IsFunctor[A]:
  override def toString = s"Functor(${value})"
  def map[B](fn: A => B): IsFunctor[B] = new Functor[B](fn(value))
  override def inspect: Unit = println(toString)

/** Factory to create Functor instances */
object Functor:
  // def apply[A](value: A) = new Functor[A](value) // -> val test: Functor[String] = Functor("save the "of" by implementing apply")
  def of[A](value: A) = new Functor[A](value)

/** Specifies what makes a functor */
trait IsFunctor[A]:
  def map[B](fn: A => B): IsFunctor[B]
  def inspect: Unit = println(toString)
