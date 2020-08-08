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
        Car skoda = new Skoda();
        Car bmw = new BMW();
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
