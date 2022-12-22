import java.util.Scanner;
public class Calculator {
    private char operation;
    private int numberOne;
    private int numberTwo;
    Scanner sc = new Scanner(System.in);
    public Calculator(char operation) {
        this.operation = operation;
    }
    public void getNumbers() {
        System.out.print("Enter the first number = ");
        numberOne = sc.nextInt();
        System.out.print("Enter the second number = ");
        numberTwo = sc.nextInt();
//        System.out.println("The expression is " + numberOne + " " + this.operation + " " + numberTwo);
    }
}
