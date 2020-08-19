package ro.jademy.carrental.car.audi;

import ro.jademy.carrental.car.Car;
import ro.jademy.carrental.enums.Color;
import ro.jademy.carrental.enums.FuelType;
import ro.jademy.carrental.enums.TransmissionType;

public class Audi extends Car {
    public Audi(int index,String make, String model, Integer year, String carType, FuelType fuelType, Integer doorNumber, Color color, TransmissionType transmissionType, String engine, long basePrice) {
        super(index,make, model, year, carType, fuelType, doorNumber, color, transmissionType, engine, basePrice);
    }
}
