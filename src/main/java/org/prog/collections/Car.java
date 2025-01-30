package org.prog.collections;

 class Car {
    private String name;
    public Car(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return name;
    }
}
