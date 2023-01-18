package src;

import src.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator cobj = new Calculator();
        cobj.printWelcomeMessage();
        cobj.showOptions();
        cobj.getOption();
        cobj.getNumbers();
    }
}