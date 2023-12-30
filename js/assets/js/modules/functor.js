/*
  This is a minimal implementation of a functor
  It simply has a "of"-function that accepts a value
  and returns an object that has "map".
*/
const Functor = {
  of: value => ({
    type: "Functor",
    value: value,
    toString() { return `${this.type}(${value})` },
    inspect() { console.log(this.toString()) },
    map: fn => Functor.of(fn(value))
  })
};

export { Functor };