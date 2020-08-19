package ro.jademy.carrental.car;

import org.apache.commons.lang3.StringUtils;
import ro.jademy.carrental.enums.Color;
import ro.jademy.carrental.enums.FuelType;
import ro.jademy.carrental.enums.TransmissionType;

import java.util.UUID;

public class Car {

    protected String id;
    protected int index;
    protected final String make;
    protected final String model;
    protected Integer year;
    protected String carType; // coupe, sedan, hatchback, convertible, wagon, SUV
    protected FuelType fuelType; // diesel, gasoline, alternative
    protected Integer doorNumber;
    protected Color color;
    protected TransmissionType transmissionType; // automatic, manual
    protected String engine;
    protected long basePrice;
    protected boolean isRented = false;

    public Car(int index, String make, String model, Integer year, String carType, FuelType fuelType, Integer doorNumber, Color color, TransmissionType transmissionType, String engine, long basePrice) {
        this.id = UUID.randomUUID().toString();
        this.index = index;
        this.make = make;
        this.model = model;
        this.year = year;
        this.carType = carType;// berlina, hatchback..
        this.fuelType = fuelType;
        this.doorNumber = doorNumber;
        this.color = color;
        this.transmissionType = transmissionType;
        this.engine = engine;
        this.basePrice = basePrice;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return StringUtils.center(String.valueOf(index), 10, " ") +
                StringUtils.center(make, 14, " ") +
                StringUtils.center(model, 16, " ") +
                StringUtils.center(String.valueOf(year), 14, ' ') +
                StringUtils.center(carType, 12, " ") +
                StringUtils.center(String.valueOf(fuelType), 14, " ") +
                StringUtils.center(String.valueOf(doorNumber), 15, ' ') +
                StringUtils.center(String.valueOf(color), 10, " ") +
                StringUtils.center(String.valueOf(transmissionType), 17, " ") +
                StringUtils.center(engine, 20, " ") +
                StringUtils.center(String.valueOf(basePrice), 8, ' ');

    }
}
