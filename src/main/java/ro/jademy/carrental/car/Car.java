package ro.jademy.carrental.car;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class Car {

    protected String id;
    protected String make;
    protected String model;
    protected Integer year;
    protected String carType; // coupe, sedan, hatchback, convertible, wagon, SUV
    protected String fuelType; // diesel, gasoline, alternative
    protected Integer doorNumber;
    protected String color;
    protected String transmissionType; // automatic, manual
    protected String engine;
    protected long basePrice;
    protected boolean isRented = false;

    public Car(String make, String model, Integer year, String carType, String fuelType, Integer doorNumber, String color, String transmissionType, String engine, long basePrice) {
        this.id = UUID.randomUUID().toString();
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

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
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
        return StringUtils.center(make, 14, " ") +
                StringUtils.center(model, 16, " ") +
                StringUtils.center(String.valueOf(year), 14, ' ') +
                StringUtils.center(carType, 12, " ") +
                StringUtils.center(fuelType, 14, " ") +
                StringUtils.center(String.valueOf(doorNumber), 15, ' ') +
                StringUtils.center(color, 10, " ") +
                StringUtils.center(transmissionType, 17, " ") +
                StringUtils.center(engine, 20, " ") +
                StringUtils.center(String.valueOf(basePrice), 8, ' ');
    }



}
