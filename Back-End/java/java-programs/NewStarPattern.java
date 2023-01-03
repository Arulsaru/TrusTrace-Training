package day_one;

import java.sql.SQLOutput;
import java.util.Scanner;

public class NewStarPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
        int num = 7;
        int row = 0;
        int col = 0;
        int whiteSpace;

        while(row < num) {
            whiteSpace = 0;
            col = 0;

            while(whiteSpace < num - row ) {
                System.out.print("-");
                whiteSpace += 1;
            }

            while(col < row) {
                System.out.print("*");
                col += 1;
            }

            System.out.println("");
            row += 1;
        }
    }
}
