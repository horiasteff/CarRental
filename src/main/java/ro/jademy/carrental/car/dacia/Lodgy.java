package ro.jademy.carrental.car.dacia;

import ro.jademy.carrental.enums.Color;
import ro.jademy.carrental.enums.FuelType;
import ro.jademy.carrental.enums.TransmissionType;

public class Lodgy extends Dacia {

    public Lodgy(int index,String model, Integer year, String carType, FuelType fuelType, Integer doorNumber, Color color, TransmissionType transmissionType, String engine, long basePrice) {
        super(index,"Dacia", model, year, carType, fuelType, doorNumber, color, transmissionType, engine, basePrice);
    }
}
