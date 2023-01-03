public class Multiplication extends Calculator {
    private int numberOne;
    private int numberTwo;
    private int result;
    public Multiplication(int numberOne, int numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }
    public void doOperation() {
        result = numberOne * numberTwo;
    }
    public void printAnswer() {
        System.out.println("The expression " + numberOne + " × " + numberTwo + " gives " + result);
    }
}
