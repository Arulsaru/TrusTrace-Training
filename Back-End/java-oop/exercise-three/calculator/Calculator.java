import java.util.Scanner;
public class Calculator implements Test {
    private int numberOne;
    private int numberTwo;
    private int option;
    private char operation;
    private char[] operations = {'+', '-', '*', '/'};
    Scanner sc = new Scanner(System.in);
    public void printWelcomeMessage() {
        System.out.println("Welcome..");
    }
    public void showOptions() {
        System.out.println("List of operations available are..");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
    }
    public void getOption() {
        System.out.println("And your option is = ");
        option = sc.nextInt();
    }
    public void setOperation() {
        operation = operations[option - 1];
    }
    public void getNumbers() {
        System.out.print("Enter the first number = ");
        numberOne = sc.nextInt();
        System.out.print("Enter the second number = ");
        numberTwo = sc.nextInt();
//        System.out.println("The expression is " + numberOne + " " + this.operation + " " + numberTwo);
    }
    public void callRespectiveObject() {
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
                Divison dobj = new Divison(numberOne, numberTwo);
                dobj.doOperation();
                dobj.printAnswer();
                break;
        }
    }
    public void doOperation() {};
}
