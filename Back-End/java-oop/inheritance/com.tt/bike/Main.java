package com.tt.bike;
public class Main {
    public static void main(String[] args) {
//        Bike bikeOne = new Bike();
//        bikeOne.startBike();
//        bikeOne.setDetails(5, 150, "disc");
//        System.out.println("The engine capacity of the bike is " + bikeOne.getEngineCapacity());
//        System.out.println("Number of Gears " + bikeOne.getNumberOfGears());
//        System.out.println("Type of Brake " + bikeOne.getTypeOfBrake());
//        bikeOne.increaseSpeed();
//        bikeOne.decreaseSpeed();
//        bikeOne.getCurrentGear();
        SuperBike superBikeOne = new SuperBike();
        superBikeOne.setDetails(6, 800, "disc");
//        System.out.println(superBikeOne.checkBikeStatus());
        superBikeOne.startBike();
//        System.out.println(superBikeOne.checkBikeStatus());
//        System.out.println(superBikeOne.getCurrentGear());
        superBikeOne.increaseSpeed();
        System.out.println(superBikeOne.getCurrentGear());
        System.out.println(superBikeOne.getSpeed());
        SuperBike superBikeTwo = new SuperBike();
        System.out.println(superBikeTwo.getCurrentGear());
        System.out.println(superBikeOne.getSpeed());
//        superBikeOne.increaseSpeed();
//        superBikeOne.increaseSpeed();
//        System.out.println(superBikeOne.getSpeed());
//        System.out.println(superBikeOne.getCurrentGear());

    }
}