package com.example.spec;

import java.util.function.Function;

/**
 * The functor interface spec.
 * 
 */
public interface IsFunctor<T> {

    <U> IsFunctor<U> map(Function<T, U> fn);

}