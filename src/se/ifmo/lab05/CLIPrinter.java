package se.ifmo.lab05;

import se.ifmo.lab05.interfaces.Printer;

public class CLIPrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

}
