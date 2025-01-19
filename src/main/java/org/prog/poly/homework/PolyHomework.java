package org.prog.poly.homework;

//TODO: Add interface IPhone
//TODO: Add interface method for call
//TODO: Add interface method for unlock
//TODO: Add class for Androind and iOS phones that implement IPhone

public class PolyHomework {

    public static <Android> void main(String[] args) {
        //TODO: create Android and IOS phones, and call usePhone() for both

        Android android = new Android();

        Iphone Android = null;
        callPhone(Android);
    }
    public static void callPhone(Iphone iphone){
            //IPhone iPhone
            Iphone.call();
            Iphone.unlock();
    }

}
