package com.crio.qcalc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

@Tag("test")
public class StandardCalculatorTest {
    private StandardCalculator standardCalculator;

    @BeforeEach
    void setup(){
        standardCalculator = new StandardCalculator();
    }


    //test for int value
    @Test
    @Tag("adiition")
    @DisplayName("Test Addition of Two Integers")
    void testAdditionOperation(){
        standardCalculator.add(1,1);
        double actualResult = standardCalculator.getResult();//int to double to avoid Type mismatch: cannot convert from double to int error.
        Assertions.assertEquals(2, actualResult);
    }

    @Test
    @Tag("subtraction")
    @DisplayName("Test Substraction of Two Integers")
    void testSubtractionOperation(){
        standardCalculator.subtract(1,1);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    @Tag("multiplication")
    @DisplayName("Test Multiplication of Two Integers")
    void testMultiplicationOperation(){
        standardCalculator.multiply(2, 3);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(6, actualResult);
    }

    @Test
    @Tag("division")
    @DisplayName("Test Division of Two Integers")
    void testDivideOperation(){
        standardCalculator.divide(6, 3);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(2, actualResult);
    }

    //Tests for Floating Point Arithmetic Operations
    @Test
    @DisplayName("Test Addition of Two Doubles")
    void testAdditionOperationForDoubles(){
        standardCalculator.add(1.0,1.5);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(2.5, actualResult);
    }

    @Test
    @Tag("subtraction")
    @DisplayName("Test Substraction of Two Doubles")
    void testSubtractionOperationForDoubles(){
        standardCalculator.subtract(10.0,20.5);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(-10.5, actualResult);
    }

    @Test
    @DisplayName("Test Multiplication of Two Doubles")
    @Tag("multiplication")
    void testMultiplicationOperationForDoubles(){
        standardCalculator.multiply(10.2,5.0);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(51.0, actualResult);
    }

    @Test
    @Tag("division")
    @DisplayName("Test Division of Two Doubles")
    void testDivisionOperationForDoubles(){
        standardCalculator.divide(10.2,5.1);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(2.0, actualResult);
    }
    //testing exception throw for illegal inputs
    
    @Test
    @Tag("adiition")
    @DisplayName("Test Addition Overflow of Two Doubles")
    void testAdditionOverflowForDoubles(){
        //Assert
        Assertions.assertThrows(ArithmeticException.class, () -> {
            standardCalculator.add(Double.MAX_VALUE, 1.0);
        });
    }

    @Test
    @Tag("subtraction")
    @DisplayName("Test Subtraction Overflow of Two Doubles")
    void testSubtractionOverflowForDoubles(){
        //Assert
        Assertions.assertThrows(ArithmeticException.class,new Executable(){
            @Override
            public void execute() throws Throwable{
                standardCalculator.subtract(-Double.MAX_VALUE,Double.MAX_VALUE);
            }
        });
    }

    @Test
    @Tag("multiplication")
    @DisplayName("Test Multiplication Overflow of Two Doubles")
    void testMultiplicationOverflowForDoubles(){
        //Assert
        Assertions.assertThrows(ArithmeticException.class,new Executable(){
            @Override
            public void execute() throws Throwable{
                standardCalculator.multiply(Double.MAX_VALUE,Double.MAX_VALUE);
            }
        });
    }
    @Test
    @Tag("multiplication")
    @DisplayName("Test Multiplication Overflow of Two Doubles in which One is Positive and Other is Negative")
    void testMultiplicationOverflowForDoublesOnePosOtherNeg(){
        //Assert
        Assertions.assertThrows(ArithmeticException.class,new Executable(){
            @Override
            public void execute() throws Throwable{
                standardCalculator.multiply(-Double.MAX_VALUE,Double.MAX_VALUE);
            }
        });
    }

    @Test
    @Tag("division")
    @DisplayName("Test Division Overflow of Two Doubles")
    void testDivisionOverflowForDoubles(){
        //Assert
        Assertions.assertThrows(ArithmeticException.class,() -> {
            standardCalculator.divide(Double.MAX_VALUE, 1.0);
        });
    }

    @Test
    @Tag("division")
    @DisplayName("Test Division By Zero")
    void testDivisionByZero(){
        //Assert
        Assertions.assertThrows(ArithmeticException.class,() -> {
            standardCalculator.divide(5.0, 0.0);
        });
    }
}
