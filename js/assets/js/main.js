import { Functor } from "./modules/functor.js";
import { Monad } from "./modules/monad.js";
/*
  All @Credits to Martin Novak @ https://github.com/MeetMartin.
  This whole project started with the very recommendable short of 7urtle Javascript:
  https://www.youtube.com/watch?v=LITiJmyiOt0
  JavaScript functional programming.
  Monad under 60 seconds
*/

/*
  Every monad is a functor. A functor is just a wrapper about some value:
*/
Functor.of('string');
Functor.of(['array']);
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
  .of('Turtle')
  .map(a => Monad.of(a + 's'));
// => Monad(Monad('Turtles'))


/*
  Instead a monad needs to implement "flatMap".
  "flatMap" flattens the result so instead of a monad inside of a monad you just have one monad.
*/
Monad
  .of('Turtle')
  .flatMap(a => Monad.of(a + 's'));
// => Monad('Turtles')

// Let's apply our monad...
Monad.of(5).flatMap(a => Monad.of(a + 1)).inspect();