package com.example;

import java.util.Arrays;

/**
  @Credits to Martin Novak @MeetMartin.
  JavaScript functional programming.
  Monad under 60 seconds
*/

/**
 * This is a Java implementation of a functor
 * It simply has a "of"-function that accepts a value
 * and returns an object that has "map".
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        /*
         * Every monad is a functor. A functor is just a wrapper about some value:
         */
        Functor.of("String");
        Functor.of(Arrays.asList("Array"));
        Functor.of(5);

        Functor.of(5).map(a -> a + 1);
        // => Functor(6)

        /*
         * To be a functor, a functor has to implement "map".
         * "map" applies a function to the value inside of the functor.
         */

        /*
         * If a functor maps a function that returns a monad
         * you would have a monad inside of a monad.
         */
        Monad.of("Turtle").map(a -> Monad.of(a + "s"));
        // => Monad(Monad('Turtles'))

        /*
        Instead a monad needs to implement "flatMap".
        "flatMap" flattens the result so instead of a monad inside of a monad you just have one monad.
        */
        Monad.of("Turtle").flatMap(a -> Monad.of(a + 's')).inspect();
        // => Monad('Turtles')

        // Let's apply our monad...
        Monad.of(5).flatMap(a -> Monad.of(a + 1)).inspect();

    }
}
