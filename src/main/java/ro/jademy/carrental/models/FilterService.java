package ro.jademy.carrental.models;

import org.apache.commons.lang3.StringUtils;
import ro.jademy.carrental.car.Car;
import ro.jademy.carrental.data.DataSource;
import ro.jademy.carrental.enums.Color;
import ro.jademy.carrental.enums.FuelType;
import ro.jademy.carrental.enums.TransmissionType;

import java.util.List;

public class FilterService {
    List<Car> cars = DataSource.carList();

    public void filterByMake(String make) {
        int i = 1;
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
        int i = 1;
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
        int i = 1;
        System.out.println(getCarHeader());
        for (Car car : cars) {
            if (car.getBasePrice() >= minPrice && car.getBasePrice() <= maxPrice) {
                System.out.print(i + ". ");
                System.out.println(car);
                i++;
            }
        }
    }

    public void filterByFuelType(FuelType fuelType) {
        int i = 1;
        System.out.println(getCarHeader());
        for (Car car : cars) {
            if (car.getFuelType().equals(fuelType)) {
                System.out.print(i + ". ");
                System.out.println(car);
                i++;
            }
        }
    }

    public void filterByColor(Color color) {
        int i = 1;
        System.out.println(getCarHeader());
        for (Car car : cars) {
            if (car.getColor().equals(color)) {
                System.out.print(i + ". ");
                System.out.println(car);
                i++;
            }
        }
    }

    public void filterByTransmission(TransmissionType transmissionType) {
        int i = 1;
        System.out.println(getCarHeader());
        for (Car car : cars) {
            if (car.getTransmissionType().equals(transmissionType)) {
                System.out.print(i + ". ");
                System.out.println(car);
                i++;
            }
        }
    }

    protected String getCarHeader() {
        return
                StringUtils.center(" INDEX", 13, " ") +
                        StringUtils.center(" MAKE", 16, " ") +
                        StringUtils.center(" MODEL", 13, " ") +
                        StringUtils.center("YEAR", 16, ' ') +
                        StringUtils.center("CAR TYPE", 10, ' ') +
                        StringUtils.center(" FUEL TYPE", 18, ' ') +
                        StringUtils.center("DOORS NUMBER", 10, ' ') +
                        StringUtils.center("  COLOR", 11, ' ') +
                        StringUtils.center("TRANSMISSION TYPE", 17, ' ') +
                        StringUtils.center("  ENGINE TYPE", 18, ' ') +
                        StringUtils.center("BASE PRICE", 12, ' ');
    }
}
