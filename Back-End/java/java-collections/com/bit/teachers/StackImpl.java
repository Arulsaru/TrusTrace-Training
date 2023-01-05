package com.bit.teachers;
import java.util.*;

public class StackImpl implements methods {
    Scanner sc = new Scanner(System.in);
    Stack <String> teachersStk = new Stack<>();
    Iterator stackIterator = teachersStk.iterator();
    private String name;
    boolean isStackEmpty() {
        return teachersStk.empty();
    }
    int getSize() {
        return teachersStk.size();
    }
    String getTeachers() {
        System.out.println("Enter the name of the teacher: ");
        return sc.nextLine();
    }
    void moveTeachersInsideStack() {
        name = getTeachers();
        teachersStk.push(name);
    }
    void removeATeacherFromStack() {
        try {
            teachersStk.pop(); // Empty stack exception chances
        } catch(EmptyStackException e) {
            System.out.println("The stack is empty");
        }
    }
    void printAllTeachers() {
        if(isStackEmpty()) {
            System.out.println("No teachers were added. The stack is empty");
        }
        else {
            while(stackIterator.hasNext()) { // concurrentModificationException hits
                System.out.println(stackIterator.next());
            }
        }
    }
    void searchATeacher() {
        int idx = teachersStk.search("ads");
        System.out.println(teachersStk.indexOf(idx));
    }
    @Override
    public void printEmptyMessage(String location) {
        System.out.println(location + " is empty");
    }
}
