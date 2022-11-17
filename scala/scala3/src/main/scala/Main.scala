/** @Credits
  *   to Martin Novak @MeetMartin. JavaScript functional programming. Monad
  *   under 60 seconds
  */

/** This is a Scala implementation of a functor and a monad. You could write
  * everything in a single file similar to the Javascript version. However to be on par
  * with the Java version, the functor and monad implementations are moved to
  * separate files.
  */
@main def main: Unit = {
  /*
  Every monad is a functor. A functor is just a wrapper about some value:
   */
  Functor.of("string");
  Functor.of(Array("array"));
  Functor.of(5);
  Functor
    .of(5)
    .map(a => a + 1);
// => Functor(6)
  /*
  To be a functor, a functor has to implement "map".
  "map" applies a function to the value inside of the functor.
   */

  /*
  If a functor maps a function that returns a monad
  you would have a monad inside of a monad.
   */
  Monad
    .of("Turtle")
    .map(a => Monad.of(a + 's'));
// => Monad(Monad('Turtles'))

  /*
  Instead a monad needs to implement "flatMap".
  "flatMap" flattens the result so instead of a monad inside of a monad you just have one monad.
   */
  Monad
    .of("Turtle")
    .flatMap(a => Monad.of(a + 's'));
// => Monad('Turtles')

  // Let's apply our monad...
  Monad.of(5).flatMap(a => Monad.of(a + 1)).inspect;

}
