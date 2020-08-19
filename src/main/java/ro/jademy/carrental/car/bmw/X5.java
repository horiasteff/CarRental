package ro.jademy.carrental.car.bmw;

import ro.jademy.carrental.enums.Color;
import ro.jademy.carrental.enums.FuelType;
import ro.jademy.carrental.enums.TransmissionType;

public class X5 extends BMW{

    public X5(int index,String model, Integer year, String carType, FuelType fuelType, Integer doorNumber, Color color, TransmissionType transmissionType, String engine, long basePrice) {
        super(index,"BMW", model, year, carType, fuelType, doorNumber, color, transmissionType, engine, basePrice);
    }
}
