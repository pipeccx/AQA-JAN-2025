package org.prog.exceptions;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

//TODO: write a method which ca cause NullPointerException
// TODO: write try-catc-finally to catch NPE
// TODO: on exception -> print "EXCEPTION CAUGHT!"
// TODO: always print "DONE TRY-CATCH-FINALLY"

public class ExceptionsHomework {
    public static void causeNullPointerException() throws NullPointerException {
        String str = null;
        System.out.println(str.length());
    }

    public static void main(String[]args){
        try {
            causeNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Exception Caught!!");
        } finally {
            System.out.println("done try-catch-finally");
        }
    }
}

