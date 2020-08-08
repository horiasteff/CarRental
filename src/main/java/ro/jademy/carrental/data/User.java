package ro.jademy.carrental.data;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String Name;
    private String password;

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
