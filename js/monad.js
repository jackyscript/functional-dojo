// @Credits to amazing explanation by Martin Novak @MeetMartin
// JavaScript functional programming
// Monad under 60 seconds

const Functor = {
    of: value => ({
        value: value,
        inspect: () => console.log(`Functor(${value})`),
        map: fn => Functor.of(fn(value))
    })
};s

const Monad = {
    of: value => ({
        value: value,
        inspect: () => console.log(`Monad(${value})`),
        map: fn => Monad.of(fn(value)),
        flatMap: fn => fn(value)
    })
};

Monad.of(5).flatMap(a => Monad.of(a + 1)).inspect();