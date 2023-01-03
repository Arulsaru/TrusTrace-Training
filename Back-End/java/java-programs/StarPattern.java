package day_one;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
public class StarPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number above or equal to 5: ");
        int num = sc.nextInt();

        if(num < 5) {
            System.out.println("Re-Enter the number again..");
        }

        if(num % 2 == 0) {
            num -= 1; // converting an even number to odd number
        }

        int tempNum = num - 2;
        int row = 1;
        int col, whiteSpace;
        int value = 1;

        while(row < num) {
            whiteSpace = (tempNum / 2) - 1;
            col = 0;

            if(row % 2 == 0) {
                tempNum -= 2;
            }
            else if( row != 1 && row % 2 == 1) {
                value += 2;
            }

            while(whiteSpace > -1) {
                System.out.print(" ");
                whiteSpace -= 1;
            }

            while(col < value) {
                System.out.print("*");
                col += 1;
            }

            System.out.println();
            row += 1;
        }
    }
}
