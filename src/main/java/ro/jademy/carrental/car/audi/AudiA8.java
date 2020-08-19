package ro.jademy.carrental.car.audi;

import ro.jademy.carrental.enums.Color;
import ro.jademy.carrental.enums.FuelType;
import ro.jademy.carrental.enums.TransmissionType;

public class AudiA8 extends Audi {

    public AudiA8(int index,String model, Integer year, String carType, FuelType fuelType, Integer doorNumber, Color color, TransmissionType transmissionType, String engine, long basePrice) {
        super(index,"Audi", model, year, carType, fuelType, doorNumber, color, transmissionType, engine, basePrice);
    }
}
