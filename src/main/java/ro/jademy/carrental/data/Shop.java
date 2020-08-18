package ro.jademy.carrental.data;

import ro.jademy.carrental.car.Car;

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
    String status;
    long thePrice = 0;


    public void start() {
        login();
        showUserMenu();
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

    private void showListMenuOptions() {

        System.out.println("Select an action from below:");
        System.out.println("1. Filter by make");
        System.out.println("2. Filter by model");
        System.out.println("3. Filter by budget");
        System.out.println("4. Rent without filter");
        System.out.println("5. Back to previous menu");
        System.out.println();

        System.out.println("What is your choice?");
        String choice = sc.next();

        switch (choice) {
            case "1":
                System.out.println("What is the MAKE of the car?");
                String make = sc.next();
                service.filterByMake(make);
                break;
            case "2":
                System.out.println("What is the MODEL of the car?");
                String model = sc.next();
                service.filterByMake(model);
                break;
            case "3":
                System.out.println("What is the BUDGET of the car?");
                System.out.println("What is the minimum price?");
                long minPrice = sc.nextInt();
                System.out.println("What is the maximum price?");
                long maxPrice = sc.nextInt();
                service.filterByBudget(minPrice, maxPrice);
                break;
            case "4":
                break;
            case "5":
                showUserMenu();
                break;
        }
    }

    private void showUserMenu() {

        System.out.println(" -----------------------------------------------");
        System.out.println("|    Welcome to the Horia's Car Rental Service   |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List all cars");
        System.out.println("2. List available cars");
        System.out.println("3. List all rented cars");
        System.out.println("4. List your rented cars");
        System.out.println("5. Change personal data");
        System.out.println("6. Show personal data info");
        System.out.println("7. Logout");
        System.out.println("8. Exit");

        if (status.equalsIgnoreCase("admin")) {
            System.out.println();
            System.out.println("                    ADMINS");
            System.out.println("9. Statistics");

        }

        System.out.println();
        System.out.println("Enter your option");
        String option = sc.next();

        switch (option) {

            case "1":
                getAllCars();
                System.out.println();
                showListMenuOptions();
                renting();
                break;
            case "2":
                getAvailableCars();
                System.out.println();
                showListMenuOptions();
                renting();
                break;
            case "3":
                getRentedCars();
                renting();
                break;
            case "4":
                System.out.println(getCurrentlyRentedCars());
                break;
            case "5":
                changeInfo();
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
                break;
            case "6":
                showInfo();
                break;
            case "7":
                login();
                showUserMenu();
                break;
            case "8":
                break;
            case "9":
                if (status.equalsIgnoreCase("admin")) {
                    statistics();
                    System.out.println("Do you want to go back to previous menu?");
                    output = sc.next();
                    if (output.equalsIgnoreCase("yes")) {
                        statistics();
                    }
                } else {
                    System.out.println("You entered a wrong number!");
                    showUserMenu();
                }

                break;
            default:
                System.out.println("You entered a wrong number!");
                showUserMenu();
                break;
        }
    }

    private void showInfo() {
        if (status.equalsIgnoreCase("user")) {
            System.out.println("You're personal info is:");
            System.out.println("Your name is: " + currentUser.getName());
            System.out.println("Your age is: " + currentUser.getAge());
            System.out.println("Your number of years of driving is: " + currentUser.getYearsOfDriving());
            System.out.println("Do you want to change some personal info?");
            output = sc.next();
            if (output.equalsIgnoreCase("yes")) {
                changeInfo();
            } else {
                showUserMenu();
            }
        } else {
            System.out.println("You're personal info is:");
            System.out.println("Your name is: " + currentAdmin.getName());
            System.out.println("Your age is: " + currentAdmin.getAge());
            System.out.println("Your number of years of driving is: " + currentAdmin.getYearsOfDriving());
            System.out.println("Do you want to change some personal info?");
            output = sc.next();
            if (output.equalsIgnoreCase("yes")) {
                changeInfo();
            } else {
                showUserMenu();
            }
        }
    }

    private void seeIncome() {
        System.out.println("Total income: $ " + thePrice);
    }

    private void changeInfo() {
        System.out.println("What do you want to change?");
        System.out.println("AGE: type 'age' ");
        System.out.println("YEARS OF DRIVING: type 'year' ");
        System.out.println("PASSWORD: type 'password' ");
        String info = sc.next();
        if (status.equalsIgnoreCase("user")) {
            if (info.equalsIgnoreCase("age")) {
                System.out.println("You're current age is: " + currentUser.getAge());
                System.out.println("What is your age?");
                int age = sc.nextInt();
                currentUser.setAge(age);
            } else if (info.equalsIgnoreCase("Year")) {
                System.out.println("For how many years are you driving?");
                int years = sc.nextInt();
                currentUser.setYearsOfDriving(years);
            } else {
                if (info.equalsIgnoreCase("password")) {
                    System.out.println("Enter your old password first");
                    String password = sc.next();
                    if (password.equals(currentUser.getPassword())) {
                        System.out.println("Enter your new password");
                        password = sc.next();
                        currentUser.setPassword(password);
                    } else {
                        System.out.println("You entered the wrong password");
                    }
                }
            }
        } else {
            if (info.equalsIgnoreCase("age")) {
                System.out.println("You're current age is: " + currentAdmin.getAge());
                System.out.println("What is your age?");
                int age = sc.nextInt();
                currentAdmin.setAge(age);
            } else if (info.equalsIgnoreCase("Year")) {
                System.out.println("You are currently driving for: " + currentAdmin.getYearsOfDriving() + " years");
                System.out.println("For how many years are you driving?");
                int years = sc.nextInt();
                currentAdmin.setYearsOfDriving(years);
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
                    }
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
    private void getAllUsers(){
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
                    if (make.equalsIgnoreCase(car.getMake()) && model.equalsIgnoreCase(car.getModel()) && color.equalsIgnoreCase(car.getColor())) {
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
        System.out.println("Please choose a number smaller than 90");
        do {
            noOfDaysAnswer = sc.nextInt();
            if (noOfDaysAnswer > 90) {
                System.out.println("Please choose a number smaller than 90");
            }
        } while (noOfDaysAnswer > 90);

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
        }
    }

    private long calculatePrice(int numberOfDays, Car car) {
        long price = car.getBasePrice();
        if (numberOfDays > 15 && numberOfDays < 90) {
            price = car.getBasePrice() - (numberOfDays - 15) * 3 + feature.deliverHome();
        } else {
            if (numberOfDays > 90) {
                System.out.println("Please choose a number smaller than 90");
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
        String option = sc.next();
        switch (option) {
            case "1":
                seeIncome();
                break;
            case "2":
                getAllUsers();
                break;
            case "3":
                showUserMenu();
                break;
        }
    }
}