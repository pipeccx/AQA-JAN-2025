package org.prog.collections;

//TODO: write collection of cars (MAP/SET/LIST)
//TODO: WHERE: CAR CAN HAVE NO OWNER
//TODO: WHERE: CAR CAN HAVE 1 OR MORE OWNERS
//TODO: Write method that will print all owners sharing car

import java.util.*;

/**
 * Car1 -> John
 * Car2 -> John, Jane
 * Car3 -> Jane
 * Car4 ->
 * Car5 -> Sarah, Peter
 * Car6 -> Peter
 * Car7 -> Bob
 * Car8 -> Ivy
 * expected result: Peter, Sarah, John, Jane
 */

public class CollectionsHomework {

    public static void main(String[] args) {
        Map<Car, Set<String>> carOwners = new HashMap<>();

        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        Car car4 = new Car("Car4");
        Car car5 = new Car("Car5");
        Car car6 = new Car("Car6");
        Car car7 = new Car("Car7");
        Car car8 = new Car("Car8");

        addOwner(car1, "John", carOwners);
        addOwner(car2, "John", carOwners);
        addOwner(car2, "Jane", carOwners);
        addOwner(car3, "Jane", carOwners);
        addOwner(car5, "Sarah", carOwners);
        addOwner(car5, "Peter", carOwners);
        addOwner(car6, "Peter", carOwners);
        addOwner(car7, "Bob", carOwners);
        addOwner(car8, "Ivy", carOwners);

        printAllOwners(carOwners);
    }
        public static void addOwner (Car car, String owner, Map<Car, Set<String>> carOwners){
            carOwners.putIfAbsent(car, new HashSet<>());
            carOwners.get(car).add(owner);
        }
        public static void printAllOwners(Map<Car, Set <String>> carOwners){
            Set<String> allOwners = new HashSet<>();
            for (Set<String> owners : carOwners.values()) {
                allOwners.addAll(owners);
            }
            List<String> sortedOwners = new ArrayList<>(allOwners);
            Collections.sort(sortedOwners);

            System.out.println(String.join(", ", sortedOwners));
        }
    }

