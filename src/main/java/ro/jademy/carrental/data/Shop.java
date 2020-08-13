package ro.jademy.carrental.data;

import org.apache.commons.lang3.StringUtils;
import ro.jademy.carrental.car.Car;

import java.util.List;
import java.util.Scanner;

public class Shop {
    Scanner sc = new Scanner(System.in);
    List<User> users = DataSource.userList();

    User currentUser = null;
    Car currentCar = null;
    int i;

    public void login() {
        boolean loginSuccess = false;
        do {
            System.out.println("Please enter the username");
            String username = sc.next();
            System.out.println("Please enter the password");
            String password = sc.next();

            for (User user : users) {
                if (username.equalsIgnoreCase(user.getName()) && password.equalsIgnoreCase(user.getPassword())) {
                    System.out.println("User: " + user.getName() + "\n");
                    loginSuccess = true;
                    currentUser = user;
                }
            }
            if (!loginSuccess) {
                System.out.println("Incorrect Username/Password");
            }
        } while (!loginSuccess);
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

        System.out.println();
        System.out.println("Enter your option");
        String option = sc.next();


        String answer;

        switch (option) {

            case "1":
                getAllCars();
                System.out.println();
                System.out.println("Do you want to rent a car?");
                answer = sc.next();
                if (answer.equalsIgnoreCase("yes")) {
                    rentACar();
                }
                break;
            case "2":
                getAvailableCars();
                System.out.println("Do you also want to rent a car?");
                answer = sc.next();
                if (answer.equalsIgnoreCase("yes")) {
                    rentACar();
                }
                break;
            case "3":
                getRentedCars();
                System.out.println("Do you also want to rent a car?");
                answer = sc.next();
                if (answer.equalsIgnoreCase("yes")) {
                    System.out.println("There are all the available cars");
                    for (Car car : DataSource.carList()) {
                        if (!car.isRented()) {
                            System.out.print(i + ". ");
                            System.out.println(car);
                            i++;
                        }
                    }
                    System.out.println();
                    rentACar();
                }
                break;
            case "4":
                System.out.println("What is the minimum price?");
                long minPrice = sc.nextInt();
                System.out.println("What is the maximum price?");
                long maxPrice = sc.nextInt();
                filterByBudget(minPrice, maxPrice);
                System.out.println();
                System.out.println("Do you want to rent a car?");
                answer = sc.next();
                if (answer.equalsIgnoreCase("yes")) {
                    rentACar();
                }
                break;
        }
    }

    private void getRentedCars() {
        i = 1;
        System.out.println("These are the rented cars");
        for (Car car : DataSource.carList()) {
            if (car.isRented()) {
                System.out.print(i);
                System.out.println(car);
                i++;
            }
        }
    }

    private void getAllCars() {
        i = 1;
        System.out.println("There are all the cars");
        System.out.println(getCarHeader());
        for (Car car : DataSource.carList()) {
            String padding = i < 10 ? " " : "";
            System.out.print(padding + i + ". ");
            System.out.println(car);
            i++;
        }
    }

    private void getAvailableCars() {
        i = 1;
        System.out.println(getCarHeader());
        System.out.println("These are the available cars");
        for (Car car : DataSource.carList()) {
            if (!car.isRented()) {
                System.out.print(i + ". ");
                System.out.println(car);
                i++;
            }
        }
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
                        System.out.println("The car you want to rent is: \n" + car);
                        car.setRented(true);
                        currentCar = car;
                        System.out.println("\nFow how many days do you want to rent the car?");
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
        i = 1;
        System.out.println(getCarHeader());
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                System.out.print(i + ". ");
                System.out.println(car);
                i++;
            }
        }
    }

    public void filterByModel(String model) {
        i = 1;
        System.out.println(getCarHeader());
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                System.out.print(i + ". ");
                System.out.println(car);
                i++;
            }
        }
    }

    public void filterByBudget(long minPrice, long maxPrice) {
        i = 1;
        System.out.println(getCarHeader());
        for (Car car : cars) {
            if (car.getBasePrice() >= minPrice && car.getBasePrice() <= maxPrice) {
                System.out.print(i + ". ");
                System.out.println(car);
                i++;
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

    private static String getCarHeader() {
        return StringUtils.center("  MAKE", 19, " ") +
                StringUtils.center("  MODEL", 14, " ") +
                StringUtils.center("YEAR", 16, ' ') +
                StringUtils.center("CAR TYPE", 8, ' ') +
                StringUtils.center("FUEL TYPE", 20, ' ') +
                StringUtils.center("DOORS NUMBER", 10, ' ') +
                StringUtils.center("COLOR", 10, ' ') +
                StringUtils.center("TRANSMISSION TYPE", 15, ' ') +
                StringUtils.center("ENGINE TYPE", 18, ' ') +
                StringUtils.center("BASE PRICE", 12, ' ');
    }
}