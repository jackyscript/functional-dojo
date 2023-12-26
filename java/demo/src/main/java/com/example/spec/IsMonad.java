package com.example.spec;

import java.util.function.Function;

/**
 * The monad interface spec.
 * 
 */
public interface IsMonad<T> extends IsFunctor<T> {

    <U> U flatMap(Function<T, U> fn);

    T getValue();

}