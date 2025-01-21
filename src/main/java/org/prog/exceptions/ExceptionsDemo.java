package org.prog.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {

    public static void main(String[] args) throws FileNotFoundException {
//        Car carOne = new Car("red");
//        Car carTwo = new Car("blue");
//        Car carThree = new Car(null);
//
//        System.out.println(carThree.color.length());
//
//        carTwo.color = "red";
//
//        System.out.println(carOne.equals(carTwo));
//        System.out.println(carOne.hashCode());
//        System.out.println(carTwo.hashCode());

        try {
            smth1(null);
        } catch (NullPointerException npe) {
            System.out.println("Oops, NPE!!");
            //UNCHECKED
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

    public static void smth1(String s) {
        smth2(s);
    }

    public static void smth2(String s) {
        smth3(s);
    }

    public static void smth3(String s) {
        smth4(s);
    }

    public static void smth4(String s) {
        System.out.println(s.equals("a"));
    }

    public static void readFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader(new File("aaa.txt"));
    }
}
