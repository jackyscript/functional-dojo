package com.example;

import java.util.function.Function;

/**
 * This is the simplest implementation of a functor
 * It simply has a "of"-function that accepts a value
 * and returns an object that has "map".
 */
public class Functor<T> {

    private T value;

    public static <T> Functor<T> of(T value) {

        Functor<T> functor = new Functor<>();
        functor.value = value;

        return functor;

    }

    public void inspect() {

        System.out.println("Functor(" + value + ")");

    }

    public Functor<T> map(Function<T, T> fn) {

        return Functor.of(fn.apply(value));

    }

}
