package day_one;
import java.util.Scanner;
public class Factorial {
    static void printFactorialValue(int number) {
        int result = 1;
        int temp = number;

        while(temp != 0) {
            result *= temp;
            temp -= 1;
        }

        System.out.println("The factorial value of " + number + " is " + result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        printFactorialValue(num);
    }
}
