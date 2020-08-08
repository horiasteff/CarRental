package ro.jademy.carrental.data;

import ro.jademy.carrental.car.Car;

import java.time.LocalDate;

public class RentedCar {

    private Car car;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private boolean isCurrentlyRented;

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
}
