package src;

import src.Calculator;

public class Subtraction extends Calculator {
    private int numberOne;
    private int numberTwo;
    private int result;
    public Subtraction(int numberOne, int numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }
    public void doOperation() {
        result = numberOne - numberTwo;
    }
    public void printAnswer() {
        System.out.println("The expression " + numberOne + " - " + numberTwo + " gives " + result);
    }
}
