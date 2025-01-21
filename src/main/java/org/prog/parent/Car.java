package org.prog.parent;

//TODO: add destination parameter to method goTo

public class Car {

    public String color;

    public Car(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car c = (Car) obj;
            if (this.color != null) {
                return this.color.equals(c.color);
            } else {
                return this.color == c.color;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (color != null) {
            return color.hashCode();
        }
        return 0;
    }

    public void goTo() {
        goTo("anywhere");
    }

    public void goTo(String destination) {
        goTo(destination, "current location");
    }

    public void goTo(String destination, String startingFrom) {
        goTo(destination, startingFrom, "nowhere");
    }

    public void goTo(String destination, String startingFrom, String passingThrough) {
        System.out.println(color + " is driving from " + startingFrom + " to "
                + destination + " stopping at " + passingThrough);
    }


    public void turnSomewhere() {
        System.out.println("Car is turning somewhere");
    }

    public void isCarRed() {
        checkCarColor("red");
    }

    void defaultAccessMethod() {
        System.out.println("This is default visibility");
    }

    protected void thisIsOnlyForChildren() {
        System.out.println("Parent method!");
    }

    private void checkCarColor(String colorSample) {
        if (color != null) {
            System.out.println(color.equals(colorSample));
        }
        System.out.println("Car is not painted!");
    }
}
