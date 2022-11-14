package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for our monad.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {

        // Let's test our monad...
        assertEquals(6, Monad.of(5).flatMap(a -> a + 1));
        
    }
}
