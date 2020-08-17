package ro.jademy.carrental.data;

import java.util.ArrayList;
import java.util.List;

public class User {

    protected String name;
    protected String password;
    protected int age;
    protected int yearsOfDriving;
    protected int nrOfAccidents;
    protected List<RentedCar> rentedCars = new ArrayList<>();

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public User(String name, String password, int age, int yearsOfDriving) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.yearsOfDriving = yearsOfDriving;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "Name='" + name + '\'' +
                ", password=" + password +
                '}';
    }
}
