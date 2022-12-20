package com.tt.bike;
public class SuperBike extends Bike{
    private boolean isCostly;

    public SuperBike(int numberOfGears, int engineCapacity, String typeOfBrake ) {
        super();
        isCostly = false;
    }
    private final int MAX_SPEED = 200;
    @Override
    public void increaseSpeed() {
        if(checkBikeStatus()) {
            printStartMessage();
            return;
        }
        else {
            tempSpeed += 10;
            tempGear += 1;
            setSpeed(tempSpeed);
            setGear(tempGear);
        }
    }

}
