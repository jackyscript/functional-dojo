package com.example;

import java.util.function.Function;

import com.example.spec.Inspectable;
import com.example.spec.IsMonad;

/**
 * To turn our functor into a monad we just add the flatMap function.
 */
public class Monad<T> implements IsMonad<T>, Inspectable {

    private T value;

    /**
     * Compute a monad with the given value
     *
     * @param <T> Type of the monad
     * @param value monad value
     * @return Monad with the given value
     */
    public static <T> Monad<T> of(T value) {

        final Monad<T> monad = new Monad<>();
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
     * @param fn Function which returns the U type as the given type T
     * @return Return a monad with the applied value
     */
    @Override
    public <U> Monad<U> map(Function<T, U> fn) {

        return of(flatMap(fn));

    }

    /**
     * Applies a function to the value of the monad.
     *
     * @param fn Function which returns the U type given the type T
     * @return Return the applied value
     */
    @Override
    public <U> U flatMap(Function<T, U> fn) {

        return fn.apply(value);

    }

    /**
     * Get the monad value.
     *
     * @return The monad value.
     */
    @Override
    public T getValue() {

        return flatMap(Function.identity());

    }
}
