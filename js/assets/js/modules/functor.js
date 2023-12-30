/*
  This is a minimal implementation of a functor
  It simply has a "of"-function that accepts a value
  and returns an object that has "map".
*/
const Functor = {
    of: value => ({
        value: value,
        inspect: () => console.log(`Value: ${value}`),
        map: fn => Functor.of(fn(value))
    })
};

export { Functor };