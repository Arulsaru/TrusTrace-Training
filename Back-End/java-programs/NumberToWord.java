package day_one;
import java.util.Scanner;
public class NumberToWord {
    static int reverseNumber(int number) {
        int temp = 0;

        while(number != 0) {
            temp = (temp * 10) + number % 10;
            number /= 10;
        }

        return temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to convert it to words: ");
        int num = sc.nextInt();

        int reversedNumber = reverseNumber(num);
        String words[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

        while(reversedNumber != 0) {
            System.out.println(words[reversedNumber%10]);
            reversedNumber /= 10;
        }

    }
}
