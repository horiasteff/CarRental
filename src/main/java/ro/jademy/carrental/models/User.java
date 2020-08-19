package ro.jademy.carrental.models;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    protected String name;
    protected String password;
    protected LocalDate birthDate;
    protected LocalDate yearsOfDriving;
    protected int nrOfAccidents;
    protected List<RentedCar> rentedCars = new ArrayList<>();


    public User(String name, String password, String birthDate, String yearsOfDriving) {
        this.name = name;
        this.password = password;
        this.birthDate = LocalDate.parse(birthDate);
        this.yearsOfDriving = LocalDate.parse(yearsOfDriving);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNrOfAccidents() {
        return nrOfAccidents;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<RentedCar> getCurrentlyRentedCars() {
        List<RentedCar> currentlyRentedCars = new ArrayList<>();
        for (RentedCar rentedCar : rentedCars) {
            if (rentedCar.isCurrentlyRented()) {
                currentlyRentedCars.add(rentedCar);
            }
        }
        return currentlyRentedCars;
    }

    public int calculateAge(){
        return LocalDate.now().getYear()- birthDate.getYear();
    }

    public int calculateDrivingYears(){
        return LocalDate.now().getYear() - yearsOfDriving.getYear();
    }

    @Override
    public String toString() {
        return "User: " +
                StringUtils.center(name,10);
    }
}
