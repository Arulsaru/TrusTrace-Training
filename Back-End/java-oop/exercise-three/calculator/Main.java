import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome..");
        Scanner sc = new Scanner(System.in);
        int option = getOptions(sc);
        char[] operations = {'+', '-', '*', '/'};
        char operation = '-';  // alternative for initialization

        if(option > 0 && option < 5) {
            operation = operations[option - 1];
        }
        else {
            System.out.println("Option unavailable enter the option again"); // alternative for goto statement
        }

        Calculator cobj = new Calculator(operation);
        cobj.getNumbers();
    }

    static int getOptions(Scanner sc) {
        System.out.println("List of operations available are..");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("And your option is = ");
        return sc.nextInt();
    }
}