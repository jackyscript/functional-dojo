import { Functor } from "./functor.js";
// To turn our functor into a monad we just add the flatMap function.
const Monad = {
  of: value => ({
    __proto__: Functor.of(value),
    flatMap: fn => fn(value)
  })
};

export { Monad };
