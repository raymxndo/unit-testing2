package com.ecpe205;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
    Calculator calc;

    @BeforeAll
    void setup(){
        calc = new Calculator();
    }
    //create a method that computes base x power of y
    @ParameterizedTest
    @MethodSource("sumInputValues")
    @DisplayName("Base and Power")
    void shouldGetThePowerOfBaseNumber(double a, double b) {
        assertEquals(Math.pow(a,b), calc.Power(a,b));
    }

    static Stream<Arguments> shouldGetThePow () {
        return Stream.of(
                Arguments.of(5,2),
                Arguments.of(4,3),
                Arguments.of(2,4),
                Arguments.of(1,8),
                Arguments.of(8,8)
        );
    }

    //create a method that computes for the factorial of a value
    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7})
    @DisplayName("Factorial")
    void ShouldCheckFactorialNum(int value){
        if(value == 3){
            assertEquals(6, calc.factorial(value));
        }else if(value == 4){
            assertEquals(24, calc.factorial(value));
        }else if(value == 5){
            assertEquals(120, calc.factorial(value));
        }else if(value == 6){
            assertEquals(720, calc.factorial(value));
        }else if(value == 7){
            assertEquals(5040, calc.factorial(value));
        }
    }

    //create a method that checks if a given string is a palindrome
    @ParameterizedTest
    @ValueSource(strings = {"eye","radar", "rotor", "madam", "refer" })
    @DisplayName("Palindrome")
    void ShouldCheckIfPalindrome(String value){
            assertEquals(value, calc.Palindrome(value));
    }










    //CREATE A TEST TO TEST isEven
    @Test
    void shouldCheckValueIsEven() {
        assertEquals(true,calc.isEven(2));
        assertEquals(false,calc.isEven(1));
    }

    @Test
    void shouldCheckValueIsOdd() {
        assertEquals(true,calc.isOdd(1));
        assertEquals(false,calc.isOdd(2));
    }


    @Test
    @DisplayName("Sum 2 encoded values")
    void shouldSumTwoEncodedValues() {

        // 1 + 2 = 3
        assertEquals(3, calc.sum(1,2) );
        assertEquals(9, calc.sum(5,4) );
        assertEquals(5, calc.sum(3,2) );
        assertEquals(14, calc.sum(5,9) );
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void shouldSumValueWithOne( int value ) {
        assertEquals(value + 1, calc.sum(value, 1));
    }

    @ParameterizedTest
    @MethodSource("sumInputValues")
    void shouldSumTwoInputValues(int a, int b) {
        assertEquals(a + b, calc.sum(a, b));
    }

    static Stream<Arguments> sumInputValues () {
        return Stream.of(
                Arguments.of(1,2),
                Arguments.of(4,6),
                Arguments.of(2,7),
                Arguments.of(3,7),
                Arguments.of(3,0)
        );
    }

    static Stream<Arguments> arrayOfIntegerSets () {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,1}),
                Arguments.of(new int[]{7,1,5,4,1}),
                Arguments.of(new int[]{7,2,8,3,4})
        );
    }


}