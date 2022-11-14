package com.example;

import java.util.function.Function;

/**
 * To turn our functor into a monad we just add the flatMap function.
 */
public class Monad<T> extends Functor<T> {

    private T value;

    /**
     * Compute a monad with the given value
     *
     * @param <T> Type of the monad
     * @param value functor value
     * @return Monad with the given value
     */
    public static <T> Monad<T> of(T value) {

        Monad<T> monad = new Monad<>();
        monad.value = value;

        return monad;

    }

    /**
     * Prints the monad value to the console.
     */
    @Override
    public void inspect() {

        System.out.println("Monad(" + value + ")");

    }

    /**
     * Applies a function to the value of the monad.
     *
     * @param fn Function which returns the same type as the given type
     * @return Return a monad with the applied value
     */
    @Override
    public Monad<T> map(Function<T, T> fn) {

        return Monad.of(fn.apply(value));

    }

    /**
     * Applies a function to the value of the monad.
     *
     * @param fn Function which returns the same type as the given type
     * @return Return the applied value
     */
    public T flatMap(Function<T, T> fn) {

        return fn.apply(value);

    }

}
