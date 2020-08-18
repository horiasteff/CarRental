package ro.jademy.carrental.data;

import ro.jademy.carrental.car.Car;
import ro.jademy.carrental.car.audi.AudiA6;
import ro.jademy.carrental.car.audi.AudiA7;
import ro.jademy.carrental.car.audi.AudiA8;
import ro.jademy.carrental.car.bmw.X5;
import ro.jademy.carrental.car.bmw.X6;
import ro.jademy.carrental.car.bmw.X7;
import ro.jademy.carrental.car.dacia.Lodgy;
import ro.jademy.carrental.car.dacia.Logan;
import ro.jademy.carrental.car.skoda.Octavia;
import ro.jademy.carrental.car.skoda.Skala;
import ro.jademy.carrental.car.skoda.Superb;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Car> carList() {
        List<Car> carList = new ArrayList<>();

        Car skoda1 = new Superb("Superb", 2016, "berlin", "diesel", 4, "grey", "automatic", "TDI", 2500);
        Car skoda2 = new Octavia("Octavia", 2015, "hatchback", "gasoline", 4, "red", "manual", "TSI", 2300);
        Car skoda3 = new Skala("Skala", 2020, "hatchback", "diesel", 4, "green", "automatic", "TDI", 3000);
        Car skoda4 = new Octavia("Octavia", 2012, "hatchback", "gasoline", 4, "maroon", "manual", "TSI", 2200);

        Car bmw1 = new X5("X5", 2015, "hatchback", "diesel", 4, "black", "manual", "TDI", 4000, true);
        Car bmw2 = new X6("X6", 2016, "hatchback", "gasoline", 4, "white", "manual", "TSI", 4200, true);
        Car bmw3 = new X6("X6", 2017, "hatchback", "diesel", 4, "blue", "automatic", "TDI", 4800, true);
        Car bmw4 = new X7("X7", 2020, "hatchback", "diesel", 4, "gold", "automatic", "TDI", 5300, true);

        Car dacia1 = new Logan("Logan", 2008, "berlina", "gasoline", 4, "red", "manual", "TSI", 1500);
        Car dacia2 = new Logan("Logan", 2010, "hatchback", "diesel", 4, "black", "manual", "TDI", 1800);
        Car dacia3 = new Lodgy("Lodgy", 2015, "berlina", "diesel", 4, "white", "manual", "TDI", 2000);
        Car dacia4 = new Lodgy("Lodgy", 2016, "hatchback", "diesel", 4, "yellow", "manual", "TDI", 2200);

        Car audi1 = new AudiA6("AudiA6", 2015, "berlina", "diesel", 4, "black", "automatic", "TDI", 3800);
        Car audi2 = new AudiA7("AudiA7", 2017, "hatchback", "diesel", 4, "white", "manual", "TDI", 4000);
        Car audi3 = new AudiA8("AudiA8", 2019, "hatchback", "gasoline", 4, "black", "manual", "TSI", 3500);
        Car audi4 = new AudiA8("AudiA8", 2020, "berlina", "diesel", 4, "grey", "automatic", "TDI", 4500);

        carList.add(skoda1);
        carList.add(skoda2);
        carList.add(skoda3);
        carList.add(skoda4);

        carList.add(bmw1);
        carList.add(bmw2);
        carList.add(bmw3);
        carList.add(bmw4);

        carList.add(dacia1);
        carList.add(dacia2);
        carList.add(dacia3);
        carList.add(dacia4);

        carList.add(audi1);
        carList.add(audi2);
        carList.add(audi3);
        carList.add(audi4);

        return carList;
    }

    public static List<User> userList() {
        List<User> users = new ArrayList<>();

        User Daniel = new User("Daniel", "1234", 30);
        User Sorin = new User("Sorin", "1234", 24);
        User Andrei = new User("Andrei", "1234", 42, 20);

        users.add(Daniel);
        users.add(Sorin);
        users.add(Andrei);
        return users;
    }

    public static List<Admin> adminList() {
        List<Admin> admins = new ArrayList<>();

        Admin Horia = new Admin("Horia", "1234",20,2);

        admins.add(Horia);
        return admins;
    }

}
