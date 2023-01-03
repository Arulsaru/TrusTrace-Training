package com.bit.students;
import java.util.List;
import java.util.Scanner;

public class Operation {
    Scanner sc = new Scanner(System.in);
    public Student addStudent() {
        Student studentObj = new Student(getRollNumberFromUser(), getNameFromUser());
        return studentObj;
    }
    public int getRollNumberFromUser() {
        System.out.println("Enter the roll number");
        return sc.nextInt();
    }
    public String getNameFromUser() {
        System.out.println("Enter the name");
        sc.nextLine();
        return sc.nextLine();
    }
    public void display(List<Student> students) {
        for(Student student: students) {
            System.out.println(student.getRollNumber());
            System.out.println(student.getName());
        }
    }

    public void deleteStudent(List<Student> students) {
        String name = getNameOfTheStudent();

        if(students.contains(name)) {
            for(Student student: students) {
                if(student.getName().equals(name)) {
                    students.remove(student);
                }
            }
        } else {
            System.out.println("The entered name is not in the list.. re enter the name again");
        }
    }

    public String getNameOfTheStudent() {
        System.out.println("Enter the name of the student you want to delete: ");
        return sc.nextLine();
    }

}
