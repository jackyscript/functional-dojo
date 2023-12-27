package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Unit test for our monad.
 */
class AppTest {

    @ParameterizedTest
    @MethodSource("provideMonadValues")
    <T, U> void testFlatMap(T expected, T value, Function<T, U> flatMapping) {

        // Let's test our monad...
        assertEquals(expected, Monad.of(value).flatMap(flatMapping));

    }

    private static Stream<Arguments> provideMonadValues() {
        return Stream.of(
                Arguments.of(6, 5, (Function<Integer, Integer>) (number -> number + 1)),
                Arguments.of(4, "Four", (Function<String, Integer>) (String::length)),
                Arguments.of("Turtles", "Turtle", (Function<String, String>) (name -> name + "s")));
    }

}
