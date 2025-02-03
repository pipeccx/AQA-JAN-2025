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
    private Map<String, Set<String>> carOwners = new HashMap<>();

    public void addOwner(String car, String owner) {
        carOwners.putIfAbsent(car, new HashSet<>());
        carOwners.get(car).add(owner);
    }

    public Set<String> getOwnersSharingCars() {
        Set<String> sharedOwners = new HashSet<>();
        for (Set<String> owners : carOwners.values()) {
            if (owners.size() > 1) {
                sharedOwners.addAll(owners);
            }
        }
        return sharedOwners;
    }
public static void main(String[] args) {
        CollectionsHomework homework = new CollectionsHomework();
        homework.addOwner("Car1","John");
        homework.addOwner("Car2","John");
        homework.addOwner("Car2","Jane");
        homework.addOwner("Car3","Jane" );
        homework.addOwner("Car4","");
        homework.addOwner("Car5", "Sarah");
        homework.addOwner("Car5","Peter");
        homework.addOwner("Car6","Peter");
        homework.addOwner("Car7","Bob");
        homework.addOwner("Car8","Ivy");
    Set<String> result = homework.getOwnersSharingCars();
System.out.println("Sharing cars: " + result);
}
}
