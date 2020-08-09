package ro.jademy.carrental.data;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String Name;
    private String password;
    private int nrOfRentedCars;
    private int age;
    private int yearsOfDriving;
    private int nrOfAccidents;

    public int getNrOfRentedCars() {
        return nrOfRentedCars;
    }

    public void setNrOfRentedCars(int nrOfRentedCars) {
        this.nrOfRentedCars = nrOfRentedCars;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearsOfDriving() {
        return yearsOfDriving;
    }

    public void setYearsOfDriving(int yearsOfDriving) {
        this.yearsOfDriving = yearsOfDriving;
    }

    public int getNrOfAccidents() {
        return nrOfAccidents;
    }

    public void setNrOfAccidents(int nrOfAccidents) {
        this.nrOfAccidents = nrOfAccidents;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return password;
    }

    List<RentedCar> rentedCars = new ArrayList<>();

    public User(String name, String password) {
        Name = name;
        this.password = password;
    }

    public RentedCar getCurrentRentedCar() {
        for (RentedCar rentedCar : rentedCars) {
            if (rentedCar.isCurrentlyRented()) {
                return rentedCar;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", password=" + password +
                '}';
    }
}
