package com.bit.students;
public class Student {
    private int rollNumber;
    private String name;
    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }
    public int getRollNumber() {
        return this.rollNumber;
    }
    public String getName() {
        return this.name;
    }
}
