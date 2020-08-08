package ro.jademy.carrental.data;

import ro.jademy.carrental.car.Car;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Q: this is the main entry point of our program. What should we do here?
//        Scanner sc = new Scanner(System.in);
//        Shop shop = new Shop();
//        shop.showMenu();
//        System.out.println("Choose an option");
//        //  shop.showListMenuOptions();
//
//        Car car1 = new Skoda("Skoda", "Superb", 2012, "hatchback", "diesel", 4, "grey", "automatic", "TDI", "20000");
//        Car car2 = new Car("Skoda", "Octavia", 2016, "berlin", "diesel", 4, "red", "manual", "TDI", "15500");
//        Car car3 = new Car("BMW", "X6", 2019, "hatchback", "diesel", 4, "white", "automatic", "TDI", "48000");
//
//
//        List<Car> carList = new ArrayList<>();
//        carList.add(car1);
//        carList.add(car2);
//        carList.add(car3);
//
//        int answer = sc.nextInt();
//        switch (answer) {
//            case 1:
//                for (Car car : carList) {
//                    System.out.println(car);
//                }
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//        }


        Shop login = new Shop();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = sc.next();
        System.out.println("Enter password");
        String password = sc.next();
        List<User> users = DataSource.userList();
        if (login.login(userName, password)) {
            login.showMenu();
            System.out.println();
            System.out.println("Enter your option");
            String option = sc.next();
            switch (option) {
                case "1":
                    for (Car car : DataSource.carList()) {
                        System.out.println(car);
                    }
                    break;
                case "2":
                    System.out.println();
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("case 4");
                    break;
            }
        } else {
            System.out.println("Enter denied");
            login.login(userName, password);
        }
//
    }


}