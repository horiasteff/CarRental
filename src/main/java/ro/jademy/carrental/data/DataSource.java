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
import ro.jademy.carrental.car.skoda.Scala;
import ro.jademy.carrental.car.skoda.Superb;
import ro.jademy.carrental.enums.Color;
import ro.jademy.carrental.enums.FuelType;
import ro.jademy.carrental.enums.TransmissionType;
import ro.jademy.carrental.models.Admin;
import ro.jademy.carrental.models.User;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Car> carList() {
        List<Car> carList = new ArrayList<>();

        Car skoda1 = new Superb(1,"Superb", 2016, "berlin", FuelType.DIESEL, 4, Color.GREY, TransmissionType.AUTOMATIC, "TDI", 2500);
        Car skoda2 = new Octavia(2,"Octavia", 2015, "hatchback", FuelType.DIESEL, 4, Color.RED, TransmissionType.MANUAL, "TSI", 2300);
        Car skoda3 = new Scala(3,"Scala", 2020, "hatchback", FuelType.ELECTRIC, 4, Color.GREEN, TransmissionType.AUTOMATIC, "TDI", 3000);
        Car skoda4 = new Octavia(4,"Octavia", 2012, "hatchback", FuelType.GASOLINE, 4, Color.MAROON, TransmissionType.MANUAL, "TSI", 2200);

        Car bmw1 = new X5(5,"X5", 2015, "hatchback", FuelType.HYBRID, 4, Color.BLACK, TransmissionType.MANUAL, "TDI", 4000);
        Car bmw2 = new X6(6,"X6", 2016, "hatchback", FuelType.GASOLINE, 4, Color.WHITE, TransmissionType.MANUAL, "TSI", 4200);
        Car bmw3 = new X6(7,"X6", 2017, "hatchback", FuelType.DIESEL, 4, Color.BLUE, TransmissionType.AUTOMATIC, "TDI", 4800);
        Car bmw4 = new X7(8,"X7", 2020, "hatchback", FuelType.ELECTRIC, 4, Color.YELLOW, TransmissionType.AUTOMATIC, "TDI", 5300);

        Car dacia1 = new Logan(9,"Logan", 2008, "berlina", FuelType.GASOLINE, 4, Color.RED, TransmissionType.MANUAL, "TSI", 1500);
        Car dacia2 = new Logan(10,"Logan", 2010, "hatchback", FuelType.GPL, 4, Color.BLACK, TransmissionType.MANUAL, "TDI", 1800);
        Car dacia3 = new Lodgy(11,"Lodgy", 2015, "berlina", FuelType.DIESEL, 4, Color.WHITE, TransmissionType.MANUAL, "TDI", 2000);
        Car dacia4 = new Lodgy(12,"Lodgy", 2016, "hatchback", FuelType.DIESEL, 4, Color.YELLOW, TransmissionType.MANUAL, "TDI", 2200);

        Car audi1 = new AudiA6(13,"AudiA6", 2015, "berlina", FuelType.DIESEL, 4, Color.BLACK, TransmissionType.AUTOMATIC, "TDI", 3800);
        Car audi2 = new AudiA7(14,"AudiA7", 2017, "hatchback", FuelType.DIESEL, 4, Color.WHITE, TransmissionType.MANUAL, "TDI", 4000);
        Car audi3 = new AudiA8(15,"AudiA8", 2019, "hatchback", FuelType.GASOLINE, 4, Color.BLACK, TransmissionType.MANUAL, "TSI", 3500);
        Car audi4 = new AudiA8(16,"AudiA8", 2020, "berlina", FuelType.ELECTRIC, 4, Color.GREY, TransmissionType.AUTOMATIC, "TDI", 4500);

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

        User Daniel = new User("Daniel", "1234", "2000-05-01","2019-07-23");
        User Sorin = new User("Sorin", "1234", "1993-04-20","2012-10-12");
        User Andrei = new User("Andrei", "1234", "1980-12-12", "2005-06-30");

        users.add(Daniel);
        users.add(Sorin);
        users.add(Andrei);
        return users;
    }

    public static List<Admin> adminList() {
        List<Admin> admins = new ArrayList<>();

        Admin Horia = new Admin("Horia", "1234","2000-05-01","2018-09-06");

        admins.add(Horia);
        return admins;
    }

}
