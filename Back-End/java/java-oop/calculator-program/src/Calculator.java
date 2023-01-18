package src;

import java.util.Scanner;
public class Calculator implements Test {
    Scanner sc = new Scanner(System.in);
    private int numberOne;
    private int numberTwo;
    private int option;
    private char operation;
    private char[] operations = {'+', '-', '*', '/'};
    public void printWelcomeMessage() {
        System.out.println("Welcome..");
    }
    public void showOptions() {
        System.out.println("List of operations available are..");
        System.out.println("1. src.Addition");
        System.out.println("2. src.Subtraction");
        System.out.println("3. src.Multiplication");
        System.out.println("4. Division");
    }
    public void getOption() {
        System.out.println("And your option is = ");
        setOption(sc.nextInt()); // option set pandre inga
        checkExceptionInOption();
    }
    public void setOption(int tempOption) {
        option = tempOption;
    }
    @Override
    public void checkExceptionInOption() {
        try {
            setOperation();
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("The requested option is not available re-enter the option again");
            getOption();
        }
    }
    public void setOperation() {
        operation = operations[option - 1];
    }
    public void getNumbers() {
        System.out.print("Enter the first number = ");
        numberOne = sc.nextInt();
        System.out.print("Enter the second number = ");
        numberTwo = sc.nextInt();
        callRespectiveObject();
    }
    public void callRespectiveObject() {
        System.out.println("Inside call respective object " + operation);
        switch (operation) {
            case '+':
                Addition aobj = new Addition(numberOne, numberTwo);
                aobj.doOperation();
                aobj.printAnswer();
                break;
            case '-':
                Subtraction sobj = new Subtraction(numberOne, numberTwo);
                sobj.doOperation();
                sobj.printAnswer();
                break;
            case '*':
                Multiplication mobj = new Multiplication(numberOne, numberTwo);
                mobj.doOperation();
                mobj.printAnswer();
                break;
            case '/':
                System.out.println("switch division " + numberOne + " " + numberTwo);
                Divison dobj = new Divison(numberOne, numberTwo);
                dobj.checkExceptionOnNumbers();
                break;
        }
    }
    @Override
    public void checkExceptionOnNumbers() {}
    public void doOperation() {}
}
