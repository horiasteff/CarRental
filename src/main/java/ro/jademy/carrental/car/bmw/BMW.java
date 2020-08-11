package ro.jademy.carrental.car.bmw;

import ro.jademy.carrental.car.Car;

public class BMW extends Car {
    private String make;
    private String model;
    private boolean hasTurbo = true;
    private String transmission;


    public BMW(String make, String model, Integer year, String carType, String fuelType, Integer doorNumber, String color, String transmissionType, String engine, String basePrice, boolean hasTurbo) {
        super(make, model, year, carType, fuelType, doorNumber, color, transmissionType, engine, basePrice);
        this.hasTurbo = hasTurbo;
    }
}
