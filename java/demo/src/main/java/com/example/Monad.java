package com.example;

import java.util.function.Function;

/**
 * To turn our functor into a monad we just add the flatMap function.
 */
public class Monad<T> extends Functor<T> {

    private T value;

    public static <T> Monad<T> of(T value) {

        Monad<T> monad = new Monad<>();
        monad.value = value;

        return monad;

    }

    @Override
    public void inspect() {

        System.out.println("Monad(" + value + ")");

    }

    @Override
    public Monad<T> map(Function<T, T> fn) {

        return Monad.of(fn.apply(value));

    }

    public T flatMap(Function<T, T> fn) {

        return fn.apply(value);

    }

}
