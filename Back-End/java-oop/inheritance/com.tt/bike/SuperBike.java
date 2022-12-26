package com.tt.bike;
public class SuperBike extends Bike{
    private boolean isCostly;
    public SuperBike() {
        super();
        isCostly = true;
    }
    private final int MAX_SPEED = 60;
    @Override
    public void increaseSpeed() {
        if(checkBikeStatus()) {
            printStartMessage();
            return;
        }
        if (checkSpeed()) {
            tempSpeed += 20;
            tempGear += 1;
            setSpeed(tempSpeed);
        }
    }

    @Override
    public void preferableAt() {
        System.out.println("Preferable for speed as well as comfort..");
    }

}
