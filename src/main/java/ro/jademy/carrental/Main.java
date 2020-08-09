package ro.jademy.carrental;

import ro.jademy.carrental.car.Car;
import ro.jademy.carrental.data.DataSource;
import ro.jademy.carrental.data.Shop;
import ro.jademy.carrental.data.User;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Shop login = new Shop();
        Scanner sc = new Scanner(System.in);
        //the user enters the username and the password

        System.out.println("Enter username");
        String userName = sc.next();
        System.out.println("Enter password");
        String password = sc.next();

        if (login.login(userName, password)) {
            login.getIndexOfUser(userName, password);
            login.showMenu();
            System.out.println();
            System.out.println("Enter your option");
            String option = sc.next();

            switch (option) {
                case "1":
                    System.out.println("There are all the cars");
                    for (Car car : DataSource.carList()) {
                        System.out.println(car);
                    }
                    break;
                case "2":
                    System.out.println("These are the rented cars");
                    for (Car car : DataSource.carList()) {
                        if (!car.isRented()) {
                            System.out.println(car);
                        }
                    }
                    break;
                case "3":
                    System.out.println("These are the rented cars");
                    for (Car car : DataSource.carList()) {
                        if (car.isRented()) {
                            System.out.println(car);
                        }
                    }
                    break;
                case "4":
                    System.out.println("case 4");
                    break;
            }
        } else {
            System.out.println("Enter denied");
        }
//
    }


}