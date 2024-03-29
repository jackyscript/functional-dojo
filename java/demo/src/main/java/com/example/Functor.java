package com.example;

import java.util.function.Function;

import com.example.spec.Inspectable;
import com.example.spec.IsFunctor;

/**
 * This is a very simple implementation of a functor.
 * It simply has a "of"-function that accepts a value
 * and returns an object that has "map".
 */
public class Functor<T> implements IsFunctor<T>, Inspectable {

    private T value;

    /**
     * Compute a functor with the given value
     *
     * @param <T> Type of the functor
     * @param value functor value
     * @return Functor with the given value
     */
    public static <T> Functor<T> of(T value) {

        final Functor<T> functor = new Functor<>();
        functor.value = value;

        return functor;

    }

    /**
     * Prints the functor value to the console.
     */
    @Override
    public void inspect() {

        System.out.println("Functor(" + value + ")");

    }

    /**
     * Applies a function to the value of the functor.
     *
     * @param fn Function which returns the U type given the type T
     * @return Return a functor with the applied value
     */
    @Override
    public <U> Functor<U> map(Function<T, U> fn) {

        return of(fn.apply(value));

    }

}
