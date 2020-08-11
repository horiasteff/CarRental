package ro.jademy.carrental.data;

import ro.jademy.carrental.car.Car;

import java.util.List;
import java.util.Scanner;

public class Shop {
    Scanner sc = new Scanner(System.in);

    public boolean login(String username, String password) {
        User loggedInUser = null;
        List<User> users = DataSource.userList();
        for (User user : DataSource.userList()) {
            if (user.getName().equals(username)) {
                if (user.getPassword().equals(password)) {
                    loggedInUser = user;
                    // when a user is found, "break" stops iterating through the list
                    break;
                }
            }
        }
        if (loggedInUser != null) {
            System.out.println("User successfully logged in: " + loggedInUser.getName());
            return true;
        } else {
            System.out.println("Invalid username/password combination");
            return false;
        }
    }

    public void showMenu() {

        System.out.println(" -----------------------------------------------");
        System.out.println("|    Welcome to the Horia Car Rental Service   |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List all cars");
        System.out.println("2. List available cars");
        System.out.println("3. List rented cars");
        System.out.println("4. List filtrated by budget");
        System.out.println("5. Check income");
        System.out.println("6. Logout");
        System.out.println("7. Exit");
    }

    public void showListMenuOptions() {

        System.out.println("Select an action from below:");
        System.out.println("1. Filter by make");
        System.out.println("2. Filter by model");
        System.out.println("3. Filter by budget");
        System.out.println("4. Back to previous menu");
    }

    List<Car> cars = DataSource.carList();

    public void rentACar() {

        boolean renting = true;
        boolean isFound = false;
        long price = 0;

        while (renting) {
            renting = false;

            System.out.println("What is the MAKE of the car you want to rent?");
            String make = sc.next();
            filterByMake(make);
            System.out.println("What is the MODEL of the car you want to rent?");
            String model = sc.next();
            filterByModel(model);
            System.out.println("What is the COLOR of the car you want to rent?");
            String color = sc.next();

            for (Car car : cars) {
                if (!car.isRented()) {
                    if (make.equalsIgnoreCase(car.getMake()) && model.equalsIgnoreCase(car.getModel()) && color.equalsIgnoreCase(car.getColor())) {
                        isFound = true;
                        System.out.println("The car you want to rent is: " + car);
                        car.setRented(true);
                        System.out.println("fow how many days do you want to rent the car?");
                        int answer = sc.nextInt();
                        System.out.println("The price of the car is:" + calculatePrice(answer, car) + "$");
                        break;
                    }
                }
            }
            if (!isFound) {
                System.out.println("We couldn't find your specified car. Try something else");
                renting = true;
            }
        }
    }

    public void filterByMake(String make) {
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                System.out.println(car);
            }
        }
    }

    public void filterByModel(String model) {
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                System.out.println(car);
            }
        }
    }

    public void filterByBudget(long minPrice, long maxPrice) {
        for (Car car : cars) {
            if(car.getBasePrice() >= minPrice && car.getBasePrice() <= maxPrice){
                System.out.println(car);
            }
        }
    }

    public long calculatePrice(int numberOfDays, Car car) {
        long price = car.getBasePrice();
        if (numberOfDays > 15) {
            price = car.getBasePrice() - (numberOfDays - 15) * 10;
        }
        return price;
    }
}