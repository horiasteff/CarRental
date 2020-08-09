package ro.jademy.carrental.data;

import ro.jademy.carrental.car.Car;

import java.util.List;

public class Shop {
    // Q: what fields and methods should this class contain?

    public boolean login(String username, String password) {

        // TODO: implement a basic users login
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

    public int getIndexOfUser(String username, String password) {

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
            System.out.println(users.indexOf(loggedInUser));
            return users.indexOf(loggedInUser);
        } else {
            return -2;
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
        System.out.println("4. Check income");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
    }

    public void showListMenuOptions() {

        System.out.println("Select an action from below:");
        System.out.println("1. Filter by make");
        System.out.println("2. Filter by model");
        System.out.println("3. Filter by budget");
        // TODO: add additional filter methods based on car specs

        System.out.println("4. Back to previous menu");

    }

    public void rentACar(String make, String model, int year, String carType, String fuelType, int doorNumbers, String color, String transmission, String engine, String price) {
        List<Car> cars = DataSource.carList();
        List<User> users = DataSource.userList();
        List<RentedCar> rentedCars = null;
        for (Car car : cars) {
            if (!car.isRented()) {
                if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) &&
                        car.getYear().equals(year) && car.getCarType().equalsIgnoreCase(carType) &&
                        car.getFuelType().equalsIgnoreCase(fuelType) && car.getDoorNumber().equals(doorNumbers) &&
                        car.getColor().equalsIgnoreCase(color) && car.getTransmissionType().equalsIgnoreCase(transmission) &&
                        car.getEngine().equalsIgnoreCase(engine) && car.getBasePrice().equalsIgnoreCase(price))

                    car.setRented(true);

            }
        }
    }

    public void calculatePrice(int numberOfDays) {
        // TODO: apply a discount to the base price of a car based on the number of rental days
        // TODO: document the implemented discount algorithm

        // TODO: for a more difficult algorithm, change this method to include date intervals and take into account
        //       weekdays and national holidays in which the discount should be smaller

        List<User> user = DataSource.userList();
        if (numberOfDays > 30) {
            user.get(user.indexOf(user));
        }

    }


}