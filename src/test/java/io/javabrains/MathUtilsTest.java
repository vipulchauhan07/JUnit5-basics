package io.javabrains;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils mathUtils;


//    @BeforeAll
//    static void beforeAllInit() {
//
//        System.out.println("This needs to run before all!");
//
//    }
//
//    @AfterAll
//    static void afterAllInit() {
//
//        System.out.println("This needs to run after all!");
//
//    }


    @BeforeEach
    void init() {

        mathUtils = new MathUtils();

    }

    @AfterEach
    void cleanUp() {

        System.out.println("Cleaning up....");

    }

//    @Test
    @RepeatedTest((3))
    @DisplayName("Testing add method")
    void testAdd() {

        int expected = 2;
        int actual = mathUtils.add(1,1);

        assertEquals(expected, actual, "The add method is add upto 2");

    }

    @Test
    @DisplayName("Multiply method")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2,2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }

    @Test
    void testDivide() {
        boolean isServerUp = true;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0) );

    }

    @Test
    void testComputeCircleArea() {

        assertEquals(314.159265358979323846, mathUtils.computeCircleArea(10), "Should return right circle area!");

    }

    @Test
    @Disabled
    @DisplayName("TDD method, Should not run!")
    void testDisabled() {
        fail("This test should be disabled!");
    }

}