package com.company;

public class Logger {
    private static int i = 0;

    public static void log( String message){
        i++;
        System.out.print(i + ". " + message + "\n");
    }
}
