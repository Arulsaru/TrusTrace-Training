package com.bit.teachers;
import java.util.*;

public class Organisation implements methods {
    Scanner sc = new Scanner(System.in);
    Stack <String> teachersStk = new Stack<>();
    Iterator stackIterator = teachersStk.iterator();
    private String name;
    boolean isStackEmpty() {
        return teachersStk.isEmpty();
    }
    String getTeachers() {
        return sc.nextLine();
    }
    void moveTeachersInsideStack() {
//        name = "ads";
        name = getTeachers();
        teachersStk.push(name);
    }

    void moveTeachersInsideQueue() {
        name = getTeachers();
        teachersStk.push(name);
    }
    void popATeacher() {
        teachersStk.pop(); // Empty stack exception
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
