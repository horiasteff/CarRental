package ro.jademy.carrental.data;

import ro.jademy.carrental.car.bmw.BMW;
import ro.jademy.carrental.car.Car;
import ro.jademy.carrental.car.bmw.X5;
import ro.jademy.carrental.car.skoda.Skoda;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<Car> carList() {
        List<Car> carList = new ArrayList<>();
        Car skoda = new Skoda("Skoda", "Superb",2016,"berlin","diesel", 4, "grey","automtic", "TDI", "25000");
        Car bmw = new X5("BWM", "X5",2020, "hatchback","diesel", 4,"black", "automatic","TDI","48000", true);
        carList.add(skoda);
        carList.add(bmw);
        return carList;
    }

    public static List<User> userList() {
        List<User> users = new ArrayList<>();

        User Horia = new User("Horia", "1234");
        User Daniel = new User("Daniel", "1234");
        User Sorin = new User("Sorin", "1234");
        users.add(Horia);
        users.add(Daniel);
        users.add(Sorin);
        return users;
    }


}
