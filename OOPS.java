/**
 * 
 * Circle is drawn
 * Trianle is drawn
 */

// Partial abstraction

abstract class TV {
    void turnOn() {
        System.out.println("Abstract class TV");
    }

    abstract void turnOff();
}

class Remote extends TV {
    @Override
    void turnOn() {
        System.out.println("TV is on");
    }

    @Override
    void turnOff() {
        System.out.println("TV is Off");
    }
}

public class OOPS {
    public static void main(String[] args) {
        Remote remote1 = new Remote();
        remote1.turnOn();
        // main method to test custom list interface

        CustomList customArr = new CustomArrayList(5);
        customArr.add(1);
        customArr.add(2);
        customArr.add(3);
        customArr.add(4);
        customArr.add(5);

        ((CustomArrayList) customArr).printArray();
    }
}
