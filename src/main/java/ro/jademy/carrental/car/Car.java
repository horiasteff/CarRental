package ro.jademy.carrental.car;

public class Car {
    public Car(){

    }

    private String make;
    private String model;
    private Integer year;
    private String carType; // coupe, sedan, hatchback, convertible, wagon, SUV
    private String fuelType; // diesel, gasoline, alternative
    private Integer doorNumber;
    private String color;
    private String transmissionType; // automatic, manual
    private String engine;
    private String basePrice;
    private boolean isRented = false;

    // Q: do we need a constructor other than the default one?
    // Q: how can we better protect the car data?


    public Car(String make, String model, Integer year, String carType, String fuelType, Integer doorNumber, String color, String transmissionType, String engine, String basePrice) {
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

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", carType='" + carType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", doorNumber=" + doorNumber +
                ", color='" + color + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", engine='" + engine + '\'' +
                ", basePrice='" + basePrice + '\'' +
                '}';
    }
}
