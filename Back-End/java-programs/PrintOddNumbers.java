package day_one;
import java.util.Scanner;

public class PrintOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range till which you wanna print odd numbers (inclusive) : ");
        int number = sc.nextInt();
        int ctr = 1;

        while(ctr <= number) {

            if(ctr % 2 == 1) {
                System.out.print(ctr + " ");
            }

            ctr += 1;
        }

    }
}