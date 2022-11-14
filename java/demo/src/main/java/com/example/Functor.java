package com.example;

import java.util.function.Function;

/**
 * This is a very simple implementation of a functor.
 * It simply has a "of"-function that accepts a value
 * and returns an object that has "map".
 */
public class Functor<T> {

    private T value;

    /**
     * Compute a functor with the given value
     *
     * @param <T> Type of the functor
     * @param value functor value
     * @return Functor with the given value
     */
    public static <T> Functor<T> of(T value) {

        Functor<T> functor = new Functor<>();
        functor.value = value;

        return functor;

    }

    /**
     * Prints the functor value to the console.
     */
    public void inspect() {

        System.out.println("Functor(" + value + ")");

    }

    /**
     * Applies a function to the value of the functor.
     *
     * @param fn Function which returns the same type as the given type
     * @return Return a functor with the applied value
     */
    public Functor<T> map(Function<T, T> fn) {

        return Functor.of(fn.apply(value));

    }

}
