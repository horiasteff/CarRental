package ro.jademy.carrental.models;

import org.apache.commons.lang3.StringUtils;
import ro.jademy.carrental.car.Car;

import java.time.LocalDate;

public class RentedCar {

    protected Car car;
    protected LocalDate pickUpDate;
    protected LocalDate returnDate;
    protected boolean isCurrentlyRented;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isCurrentlyRented() {
        return isCurrentlyRented;
    }

    public void setCurrentlyRented(boolean currentlyRented) {
        isCurrentlyRented = currentlyRented;
    }

    @Override
    public String toString() {
        return "RentedCar: " +
                "Car=" + car + "\n" +
                StringUtils.center(String.valueOf(pickUpDate), 15, " ") +
                StringUtils.center(String.valueOf(returnDate), 15, " ") + "\n";
    }
}
