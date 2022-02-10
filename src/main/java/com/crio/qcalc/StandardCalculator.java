package com.crio.qcalc;

public class StandardCalculator {

    //private int result;//to store the result operation
    //private double result;
    protected double result;

    public static void getVersion(){
        System.out.println("Standard Calculator 1.0");
    }

    public double getResult() { //int -> double
		return result;
    }
    
    // public void setResult(int value){
    //     if(value != 0){
    //         return;
    //     }
    //     this.result = value;
    // }
    public void clearResult(){
        result = 0;
    }

    //helper method which prints the current value of the result variable in a more fashionable way.
    public void printResult(){
        System.out.println("Standard Calculator Result:"+ result);
    }

    //other arithmetic operation methods

    public final void add(int num1, int num2){
        
        add((double)num1, (double)num2);//Re-use Implementation
    }

    public final void subtract(int num1, int num2){
        subtract((double)num1, (double)num2);
    }

    public final void multiply(int num1, int num2){
        multiply((double)num1, (double)num2);
    }

    public final void divide(int num1, int num2){
        divide((double)num1, (double)num2);
    }

    //method overloading -> logic 
    public final void add(double num1, double num2){

        double result = num1 + num2; 
        if(result == Double.MAX_VALUE || result == Double.POSITIVE_INFINITY){
            throw new ArithmeticException("ADD Double Overflow");
        }
        this.result = result;
    }

    public final void subtract(double num1, double num2){

        double result = num1 - num2;//local variable
        if((result == -Double.MAX_VALUE) || (result == Double.NEGATIVE_INFINITY)){

            throw new ArithmeticException("SUBS Double overflow");
    
        }
        this.result = result; //if illegal input feed then it is not going to directly store in result object variable
    }

    public final void multiply(double num1, double num2){

        double result = num1 * num2;
        if(result == Double.MAX_VALUE || result == Double.POSITIVE_INFINITY || (result == -Double.MAX_VALUE) || (result == Double.NEGATIVE_INFINITY)){
            throw new ArithmeticException("MULTI Double Overflow");
        }
        this.result = result;
    
    }

    public final void divide(double num1, double num2){

        if(num2 == 0.0){
            throw new ArithmeticException("DIVISION By Zero");
        }
        double result = num1 / num2;
        if(result == Double.MAX_VALUE || result == Double.POSITIVE_INFINITY){
            throw new ArithmeticException("DIVISION Double Overflow");
        }
        this.result = result;
    }
}
