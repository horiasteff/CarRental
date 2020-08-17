package ro.jademy.carrental.data;

import ro.jademy.carrental.car.Car;

import java.util.List;
import java.util.Scanner;

public class Shop {
    Scanner sc = new Scanner(System.in);
    List<User> users = DataSource.userList();
    FilterService service = new FilterService();
    List<Car> cars = DataSource.carList();
    RentedCar rentedCar = new RentedCar();

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

    public void showListMenuOptions() {

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
                showMenu();
                break;
        }
    }

    public void showMenu() {

        System.out.println(" -----------------------------------------------");
        System.out.println("|    Welcome to the Horia's Car Rental Service   |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List all cars");
        System.out.println("2. List available cars");
        System.out.println("3. List rented cars");
        System.out.println("4. Check income");
        System.out.println("5. Change personal data");
        System.out.println("6. Show personal data info");
        System.out.println("7. Logout");
        System.out.println("8. Exit");

        System.out.println();
        System.out.println("Enter your option");
        String option = sc.next();
        String output;

        switch (option) {

            case "1":
                getAllCars();
                System.out.println();
                showListMenuOptions();
                System.out.println("Do you want to rent a car?");
                output = sc.next();
                if (output.equalsIgnoreCase("yes")) {
                    rentACar();
                }
                break;
            case "2":
                getAvailableCars();
                System.out.println("Do you also want to rent a car?");
                output = sc.next();
                if (output.equalsIgnoreCase("yes")) {
                    rentACar();
                }
                break;
            case "3":
                System.out.println(currentUser.getCurrentRentedCar());
                System.out.println("Do you want to rent a car?");
                String choice = sc.next();
                if (choice.equalsIgnoreCase("yes")) {
                    showMenu();
                } else {
                    if(choice.equalsIgnoreCase("no")){
                        System.out.println("Want to exit or login with another account?");
                        output = sc.next();
                        if(output.equalsIgnoreCase("login")){
                            login();
                        }else{
                            break;
                        }
                    }
                }
                break;
            case "4":
                System.out.println();
                System.out.println("Do you want to rent a car?");
                output = sc.next();
                if (output.equalsIgnoreCase("yes")) {
                    rentACar();
                }
                break;
            case "5":
                changeInfo();
                System.out.println("Do you want to go back to previous menu?");
                output = sc.next();
                if (output.equalsIgnoreCase("yes")) {
                    showMenu();
                }
                break;
            case "6":
                System.out.println("You're personal info is:");
                System.out.println("Your name is: " + currentUser.getName());
                System.out.println("Your age is: " + currentUser.getAge());
                System.out.println("Your number of years of driving is: " + currentUser.getYearsOfDriving());
                System.out.println("Do you want to go to the previous menu?");
                output = sc.next();
                if (output.equalsIgnoreCase("yes")) {
                    showMenu();
                }
                break;
            case "7":
                login();
                showMenu();
                break;
            case "8":
                break;
            default:
                System.out.println("You entered a wrong number");
                showMenu();
                break;
        }
    }

    private void changeInfo() {
        System.out.println("What do you want to change?");
        String info = sc.next();
        if (info.equalsIgnoreCase("age")) {
            System.out.println("You're current age is: " + currentUser.getAge());
            System.out.println("What is your age?");
            int age = sc.nextInt();
            currentUser.setAge(age);
        } else {
            if (info.equalsIgnoreCase("Year")) {
                System.out.println("For how many years are you driving?");
                int years = sc.nextInt();
                currentUser.setYearsOfDriving(years);
            }
        }
    }

    private void getAllCars() {
        i = 1;
        System.out.println("There are all the cars");
        System.out.println(service.getCarHeader());
        for (Car car : DataSource.carList()) {
            String padding = i < 10 ? " " : "";
            System.out.print(padding + i + ". ");
            System.out.println(car);
            i++;
        }
    }
//
//    private void getRentedCars() {
//        i = 1;
//        System.out.println("These are the rented cars");
//        for (Car car : DataSource.carList()) {
//            if (car.isRented()) {
//                System.out.print(i);
//                System.out.println(car);
//                i++;
//            }
//        }
//    }

    private void getAvailableCars() {
        i = 1;
        System.out.println(service.getCarHeader());
        System.out.println("These are the available cars");
        for (Car car : DataSource.carList()) {
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
        showMenu();
    }

    private void numberOfDays(Car car) {
        int answer;
        System.out.println("The car you want to rent is: \n" + car);

        System.out.println("\nFow how many days do you want to rent the car?");
        System.out.println("Please choose a number smaller than 50");
        do {
            answer = sc.nextInt();
            if (answer > 50) {
                System.out.println("Please choose a number smaller than 50");
            }
        } while (answer > 50);

        System.out.println("The price of the car is:" + calculatePrice(answer, car) + "$");
        car.setRented(true);
        currentCar = car;
        rentedCar.setCar(car);
        rentedCar.setCurrentlyRented(true);
        currentUser.rentedCars.add(rentedCar);
    }

    private long calculatePrice(int numberOfDays, Car car) {
        long price = car.getBasePrice();
        if (numberOfDays > 15 && numberOfDays < 50) {
            price = car.getBasePrice() - (numberOfDays - 15) * 10;
        } else {
            if (numberOfDays > 50) {
                System.out.println("Please choose a number smaller than 50");
            }
        }
        return price;
    }
}