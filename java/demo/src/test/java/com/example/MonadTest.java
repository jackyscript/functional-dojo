package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.spec.IsMonad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Unit test for our monad.
 */
class MonadTest {

    @ParameterizedTest
    @MethodSource("provideMonadValues")
    <T> void testMonad(IsMonad<T> monad, T value) {

        // Let's test our monad...
        assertEquals(monad.getValue(), value);

    }

    private static Stream<Arguments> provideMonadValues() {

        return Stream.of(
                Arguments.of(Monad.of(6), 6),
                Arguments.of(Monad.of("Dejafu"), "Dejafu"),
                Arguments.of(Monad.of(true), true),
                Arguments.of(Monad.of(Long.MAX_VALUE), Long.MAX_VALUE));

    }

}
