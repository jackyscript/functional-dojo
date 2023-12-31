/*
  This is a minimal implementation of a functor
  It simply has a "of"-function that accepts a value
  and returns an object that has "map".
*/
const Functor = {
  of: function createFunctor(value, type = "Functor") {
    return {
      value: value,
      toString: () => `${type}(${value})`,
      inspect: function logInConsole() { console.log(this.toString()) },
      map: fn => Functor.of(fn(value, type))
    };
  }
};

export { Functor };