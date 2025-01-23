package org.prog.exceptions;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

//TODO: write a method which ca cause NullPointerException
// TODO: write try-catc-finally to catch NPE
// TODO: on exception -> print "EXCEPTION CAUGHT!"
// TODO: always print "DONE TRY-CATCH-FINALLY"

public class ExceptionsHomework {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            picture1(null);
        } catch (NullPointerException npe) {
            System.out.println("Oops, NPE!!");
        } catch (RuntimeException rte) {
            System.out.println("RTE!!!");
        } catch (Exception e) {
            System.out.println("Exception!!");
        } catch (Throwable t) {
            System.out.println("Throwable!");
        } finally {
            System.out.println("this will always work!");
        }
        System.out.println("after exception");
    }

    public static void picture1(String s) {
        picture2(s);
    }

    public static void picture2(String s) {
        picture3(s);
    }

    public static void picture3(String s) {
        picture4(s);
    }

    public static void picture4(String s) {
        System.out.println(s.equals("a"));
    }

    public static void readFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader(new File("aaa.txt"));
    }
}

