package ro.jademy.carrental.models;

import ro.jademy.carrental.car.Car;
import ro.jademy.carrental.data.DataSource;
import ro.jademy.carrental.enums.Color;
import ro.jademy.carrental.enums.FuelType;
import ro.jademy.carrental.enums.TransmissionType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    Scanner sc = new Scanner(System.in);
    List<User> users = DataSource.userList();
    List<Admin> admins = DataSource.adminList();
    FilterService service = new FilterService();
    List<Car> cars = DataSource.carList();
    Features feature = new Features();
    User currentUser = null;
    Admin currentAdmin = null;
    String output;
    String option;
    String status;
    long thePrice = 0;

    public void start() {
        login();
        if (status.equalsIgnoreCase("user")) {
            showUserMenu();
        } else {
            showAdminMenu();
        }
    }

    private void login() {
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
                    status = "user";
                }
            }
            for (Admin admin : admins) {
                if (username.equalsIgnoreCase(admin.getName()) && password.equalsIgnoreCase(admin.getPassword())) {
                    System.out.println("Admin: " + admin.getName() + "\n");
                    loginSuccess = true;
                    currentAdmin = admin;
                    status = "admin";
                }
            }
            if (!loginSuccess) {
                System.out.println("Incorrect Username/Password");
            }
        } while (!loginSuccess);
    }

    private void showAdminMenu() {
        System.out.println(" -----------------------------------------------");
        System.out.println("|    Welcome to the Horia's Car Rental Service   |");
        System.out.println("|        ~  You are logged as an ADMIN  ~        |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List all cars");
        System.out.println("2. List available cars");
        System.out.println("3. List all rented cars");
        System.out.println("4. Statistics");
        System.out.println("5. Change password");
        System.out.println("6. Show personal info");
        System.out.println("7. Logout");
        System.out.println("8. Exit");
        System.out.println();

        System.out.println("Enter your option");
        boolean isValid = false;
        do {

            option = sc.next();

            switch (option) {
                case "1":
                    getAllCars();
                    System.out.println("Want to go back to previous menu?");
                    output = sc.next();
                    if (output.equalsIgnoreCase("yes")) {
                        showAdminMenu();
                    }
                    isValid = true;
                    break;
                case "2":
                    getAvailableCars();
                    System.out.println();
                    System.out.println("Want to go back to previous menu?");
                    output = sc.next();
                    if (output.equalsIgnoreCase("yes")) {
                        showAdminMenu();
                    }
                    isValid = true;
                    break;
                case "3":
                    getRentedCars();
                    System.out.println("Want to go back to previous menu?");
                    output = sc.next();
                    if (output.equalsIgnoreCase("yes")) {
                        showAdminMenu();
                    }
                    isValid = true;
                    break;
                case "4":
                    statistics();
                    System.out.println("Do you want to go back to previous menu?");
                    output = sc.next();
                    if (output.equalsIgnoreCase("yes")) {
                        statistics();
                    } else {
                        System.out.println("You entered a wrong number!");
                        showUserMenu();
                    }
                    isValid = true;
                    break;
                case "5":
                    changePassword();
                    System.out.println("Do you want to go back to previous menu?");
                    output = sc.next();
                    if (output.equalsIgnoreCase("yes")) {
                        showUserMenu();
                    } else if (output.equalsIgnoreCase("no")) {
                        System.out.println("Do you want to exit or re-login?");
                        output = sc.next();
                        if (output.equalsIgnoreCase("login")) {
                            login();
                            showUserMenu();
                        } else {
                            break;
                        }
                    }
                    isValid = true;
                    break;
                case "6":
                    showInfo();
                    isValid = true;
                case "7":
                    login();
                    if (status.equalsIgnoreCase("user")) {
                        showUserMenu();
                    } else {
                        showAdminMenu();
                    }
                    isValid = true;
                    break;
                case "8":
                    isValid = true;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    isValid = false;
                    break;
            }
        } while (!isValid);

    }

    private void showUserMenu() {

        System.out.println(" -----------------------------------------------");
        System.out.println("|    Welcome to the Horia's Car Rental Service   |");
        System.out.println("|         ~  You are logged as an USER  ~        |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List all cars");
        System.out.println("2. List available cars");
        System.out.println("3. List all rented cars");
        System.out.println("4. List your rented cars");
        System.out.println("5. Change password");
        System.out.println("6. Show personal info");
        System.out.println("7. Filter cars");
        System.out.println("8. Logout");
        System.out.println("9. Exit");

        System.out.println();
        System.out.println("Enter your option");

        boolean isValidChoice = false;

        do {
            String choice = sc.next();
            switch (choice) {
                case "1":
                    getAllCars();
                    System.out.println();
                    renting();
                    isValidChoice = true;
                    break;
                case "2":
                    getAvailableCars();
                    System.out.println();
                    renting();
                    isValidChoice = true;
                    break;
                case "3":
                    getRentedCars();
                    renting();
                    isValidChoice = true;
                    break;
                case "4":
                    System.out.println(getCurrentlyRentedCars());
                    isValidChoice = true;
                    break;
                case "5":
                    changePassword();
                    System.out.println("Do you want to go back to previous menu?");
                    output = sc.next();
                    if (output.equalsIgnoreCase("yes")) {
                        showUserMenu();
                    } else if (output.equalsIgnoreCase("no")) {
                        System.out.println("Do you want to exit or re-login?");
                        output = sc.next();
                        if (output.equalsIgnoreCase("login")) {
                            login();
                            showUserMenu();
                        } else {
                            break;
                        }
                    }
                    isValidChoice = true;
                    break;
                case "6":
                    showInfo();
                    isValidChoice = true;
                    break;
                case "7":
                    showListMenuOptions();
                    isValidChoice = true;
                    break;
                case "8":
                    login();
                    if (status.equalsIgnoreCase("user")) {
                        showUserMenu();
                    } else {
                        showAdminMenu();
                    }
                    isValidChoice = true;
                    break;
                case "9":
                    isValidChoice = true;
                    break;

                default:
                    System.out.println("You entered a wrong number!");
                    showUserMenu();
                    isValidChoice = false;
                    break;
            }
        } while (!isValidChoice);
    }

    private void showListMenuOptions() {

        System.out.println("Select an action from below:");
        System.out.println("1. Filter by make");
        System.out.println("2. Filter by model");
        System.out.println("3. Filter by budget");
        System.out.println("4. Filter by Fuel Type");
        System.out.println("5. Filter by Color");
        System.out.println("6. Filter by Transmission Type");
        System.out.println("7. Rent without filter");
        System.out.println("8. Back to previous menu");
        System.out.println();

        System.out.println("What is your choice?");

        boolean isValidChoice = false;
        do {
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("What is the MAKE of the car?");
                    String make = sc.next();
                    service.filterByMake(make);
                    renting();
                    isValidChoice = true;
                    break;
                case "2":
                    System.out.println("What is the MODEL of the car?");
                    String model = sc.next();
                    service.filterByModel(model);
                    renting();
                    isValidChoice = true;
                    break;
                case "3":
                    System.out.println("What is the BUDGET of the car?");
                    System.out.println("What is the minimum price?");
                    long minPrice = sc.nextInt();
                    System.out.println("What is the maximum price?");
                    long maxPrice = sc.nextInt();
                    service.filterByBudget(minPrice, maxPrice);
                    renting();
                    isValidChoice = true;
                    break;
                case "4":
                    System.out.println("What is the fuel type?");
                    String fuel = sc.next().toUpperCase();
                    service.filterByFuelType(FuelType.valueOf(fuel));
                    renting();
                    isValidChoice = true;
                    break;
                case "5":
                    System.out.println("What is the color?");
                    String color = sc.next().toUpperCase();
                    service.filterByColor(Color.valueOf(color));
                    renting();
                    isValidChoice = true;
                    break;
                case "6":
                    System.out.println("What is the transmission type?");
                    String transmission = sc.next().toUpperCase();
                    service.filterByTransmission(TransmissionType.valueOf(transmission));
                    break;
                case "7":
                    renting();
                    isValidChoice = true;
                    break;
                case "8":
                    showUserMenu();
                    isValidChoice = true;
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    isValidChoice = false;
                    break;
            }
        } while (!isValidChoice);
    }

    private void showInfo() {
        if (status.equalsIgnoreCase("user")) {
            System.out.println("You're personal info is:");
            System.out.println("Your name is: " + currentUser.getName());
            System.out.println("Your age is: " + currentUser.calculateAge());
            System.out.println("Your number of years of driving is: " + currentUser.calculateDrivingYears());
            System.out.println("Do you want to change some personal info?");
            boolean isValid;
            do {
                output = sc.next();
                if (output.equalsIgnoreCase("yes")) {
                    changePassword();
                    isValid = true;
                } else if (output.equalsIgnoreCase("no")) {
                    showUserMenu();
                    isValid = true;
                } else {
                    System.out.println("Please select between 'yes' and 'no'");
                    isValid = false;
                }
            } while (!isValid);

        } else {
            System.out.println("You're personal info is:");
            System.out.println("Your name is: " + currentAdmin.getName());
            System.out.println("Your age is: " + currentAdmin.calculateAge());
            System.out.println("Your number of years of driving is: " + currentAdmin.calculateDrivingYears());
            System.out.println("Do you want to change some personal info?");
            boolean isValid;
            do {
                output = sc.next();
                if (output.equalsIgnoreCase("yes")) {
                    changePassword();
                    isValid = true;
                } else if (output.equalsIgnoreCase("no")) {
                    showUserMenu();
                    isValid = true;
                } else {
                    System.out.println("Please choose between 'yes' and 'no'");
                    isValid = false;
                }
            } while (!isValid);
        }
    }

    private void seeIncome() {
        System.out.println("Total income: $ " + thePrice);
    }

    private void changePassword() {
        System.out.println("PASSWORD: type 'password' ");
        String info = sc.next();
        if (status.equalsIgnoreCase("user")) {
            if (info.equalsIgnoreCase("password")) {
                System.out.println("Enter your old password first");
                String password = sc.next();
                if (password.equals(currentUser.getPassword())) {
                    System.out.println("Enter your new password");
                    password = sc.next();
                    currentUser.setPassword(password);
                } else {
                    System.out.println("You entered the wrong password");
                    showUserMenu();
                }
            }
        } else {
            if (info.equalsIgnoreCase("password")) {
                System.out.println("Enter your old password first");
                String password = sc.next();
                if (password.equals(currentAdmin.getPassword())) {
                    System.out.println("Enter your new password");
                    password = sc.next();
                    currentAdmin.setPassword(password);
                } else {
                    System.out.println("You entered the wrong password");
                    showUserMenu();
                }
            }
        }
    }

    private void getAllCars() {
        int i = 1;
        System.out.println("There are all the cars");
        System.out.println(service.getCarHeader());
        for (Car car : DataSource.carList()) {
            String padding = i < 10 ? " " : "";
            System.out.print(padding + i + ". ");
            System.out.println(car);
            i++;
        }
    }

    private void getAllUsers() {
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.rentedCars);
        }
    }

    private void getRentedCars() {
        int i = 1;
        System.out.println("These are the rented cars");
        for (Car car : cars) {
            if (car.isRented()) {
                System.out.print(i);
                System.out.println(car);
                i++;
            }
        }
    }

    private void getAvailableCars() {
        int i = 1;
        System.out.println(service.getCarHeader());
        System.out.println("These are the available cars");
        for (Car car : cars) {
            if (!car.isRented()) {
                System.out.print(i + ". ");
                System.out.println(car);
                i++;
            }
        }
    }

    private void rentACar() {

        boolean renting = true;
        boolean isFound = false;

        while (renting) {
            renting = false;
            System.out.println("Choose 'I' for renting the index or 'F' to go with a filter");
            output = sc.next().toUpperCase();
            if (output.equals("I")) {
                boolean isValid = false;
                do {
                    System.out.println("Choose index");
                    int index = sc.nextInt();
                    for (Car car : cars) {
                        if (!car.isRented()) {
                            if (index == car.getIndex()) {
                                isFound = true;
                                isValid = true;
                                numberOfDays(car);
                            } else {
                                isValid = false;
                            }
                        }
                    }
                } while (!isValid);
            } else if (output.equals("F")) {
                showListMenuOptions();
                System.out.println("What is the MAKE of the car you want to rent?");
                String make = sc.next();
                service.filterByMake(make);
                System.out.println("What is the MODEL of the car you want to rent?");
                String model = sc.next();
                service.filterByModel(model);
                System.out.println("What is the COLOR of the car you want to rent?");
                String color = sc.next();

                for (Car car : cars) {
                    if (!car.isRented()) {
                        if (make.equalsIgnoreCase(car.getMake()) && model.equalsIgnoreCase(car.getModel()) && color.equalsIgnoreCase(String.valueOf(car.getColor()))) {
                            isFound = true;
                            if (car.getMake().equalsIgnoreCase("bmw")) {
                                System.out.println("What is your age?");
                                int age = sc.nextInt();
                                if (age < 25) {
                                    System.out.println("You can't rent this type of car");
                                    rentACar();
                                } else {
                                    numberOfDays(car);
                                    break;
                                }
                            } else {
                                numberOfDays(car);
                                break;
                            }
                        }
                    }
                }
            } else {
                System.out.println("Please choose from the options");
            }
            if (!isFound) {
                System.out.println("We couldn't find your specified car. Try something else");
                renting = true;
            }
        }
        showUserMenu();
    }

    private void numberOfDays(Car car) {
        int noOfDaysAnswer;

        System.out.println("The car you want to rent is: \n" + car);
        System.out.println("\nFow how many days do you want to rent the car?");
        System.out.println("Please choose a number smaller than 30");
        do {
            noOfDaysAnswer = sc.nextInt();
            if (noOfDaysAnswer > 30) {
                System.out.println("Please choose a number smaller than 90");
            }
        } while (noOfDaysAnswer > 30);

        long price = calculatePrice(noOfDaysAnswer, car);
        thePrice += price;
        System.out.println("The price of the car is: $" + price);
        car.setRented(true);
        RentedCar currentCar = new RentedCar();
        currentCar.setCar(car);
        currentCar.setCurrentlyRented(true);
        currentCar.setPickUpDate(LocalDate.now());
        currentCar.setReturnDate(currentCar.getPickUpDate().plusDays(noOfDaysAnswer));
        currentUser.rentedCars.add(currentCar);
        feature.payInRates(price);

        System.out.println("Do you want to go to the main page, re-login or exit?");
        output = sc.next();
        if (output.equalsIgnoreCase("return")) {
            showUserMenu();
        } else if (output.equalsIgnoreCase("login")) {
            login();
            showUserMenu();
        } else if (output.equalsIgnoreCase("exit")) {
            exit();
        }
    }

    private String exit() {
        return null;
    }

    private long calculatePrice(int numberOfDays, Car car) {
        long price = car.getBasePrice();
        if (numberOfDays > 15 && numberOfDays < 30) {
            price = car.getBasePrice() - (numberOfDays - 15) * 3 + feature.deliverHome();
        } else {
            if (numberOfDays > 30) {
                System.out.println("Please choose a number smaller than 30");
            }
        }
        return price;
    }

    private List<RentedCar> getCurrentlyRentedCars() {
        List<RentedCar> rentedCars = new ArrayList<>();
        for (User user : users) {
            rentedCars.addAll(user.getCurrentlyRentedCars());
        }
        return rentedCars;
    }

    private void renting() {
        System.out.println("Do you want to rent a car?");
        output = sc.next();
        if (output.equalsIgnoreCase("yes")) {
            rentACar();
        }
    }

    private void statistics() {
        System.out.println("                    STATISTICS");
        System.out.println("1. Show total income");
        System.out.println("2. Show list of users");
        System.out.println("3. Go to the previous menu");
        boolean isValid = false;
        do {
            String option = sc.next();
            switch (option) {
                case "1":
                    seeIncome();
                    isValid = true;
                    break;
                case "2":
                    getAllUsers();
                    isValid = true;
                    break;
                case "3":
                    showUserMenu();
                    isValid = true;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    isValid = false;
                    break;
            }
        } while (!isValid);
    }

    private void chooseIndex(int index) {
        for (Car car : cars) {
            if (!car.isRented()) {
                if (index == car.getIndex()) {
                    numberOfDays(car);
                }
            }
        }
    }
}