package src;

import src.Calculator;

public class Divison extends Calculator {
    private int numberOne;
    private int numberTwo;
    private int result;
    public Divison(int numberOne, int numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }
    @Override
    public void checkExceptionOnNumbers() {
        try {
            doOperation();
            System.out.println(numberOne + " " + numberTwo);
        } catch(ArithmeticException e) {
            System.out.println("src.Divison by zero");
            super.setOption(4); // 4 is for division
            super.setOperation();
            super.getNumbers();
        }
        printAnswer();
    }
    public void doOperation() {
        result = numberOne / numberTwo;
    }
    public void printAnswer() {
        System.out.println("The expression " + numberOne + " / " + numberTwo + " gives " + result);
    }
}
