package ro.jademy.carrental.car.skoda;

import ro.jademy.carrental.enums.Color;
import ro.jademy.carrental.enums.FuelType;
import ro.jademy.carrental.enums.TransmissionType;

public class Scala extends Skoda {

    public Scala(int index,String model, Integer year, String carType, FuelType fuelType, Integer doorNumber, Color color, TransmissionType transmissionType, String engine, long basePrice) {
        super(index,"Skoda", model, year, carType, fuelType, doorNumber, color, transmissionType, engine, basePrice);
    }
}
