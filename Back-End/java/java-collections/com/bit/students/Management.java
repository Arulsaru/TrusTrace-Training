package com.bit.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    Scanner sc = new Scanner(System.in);
    private int option;
    List <Student> students = new ArrayList<>();
    Operation obj = new Operation();
    public void displayMenu() {
        System.out.println("Options available are..");
        System.out.println("1. Add Student");
        System.out.println("2. Delete a Student");
        System.out.println("3. Display Student");
        System.out.println("9. Exit");

        getOperation();
    }
    public void getOperation() {
        System.out.println("And your operation is ");
        option = sc.nextInt();
        functionCall();
    }
    public void functionCall() {
        switch (option) {
            case 1:
                students.add(obj.addStudent());
                if(continueOrNot()) {
                    break;
                } else {
                    displayMenu();
                }
            case 2:
                obj.display(students);
                break;
            case 3:
                obj.deleteStudent(students);
                break;
            case 9:
                System.out.println("Thank You");
                System.exit(0);
            default:
                System.out.println("You have entered a invalid option" + "\n" + "Re - enter the option again..");
                displayMenu();
        }
    }
    public boolean continueOrNot() {
        System.out.println("Press 0 to exit and 1 to continue");
        return (sc.nextInt() == 1 ? false : true);
    }
}
