package ro.jademy.carrental.data;

import org.apache.commons.lang3.StringUtils;
import ro.jademy.carrental.car.Car;

import java.util.List;

public class FilterService {
    int i;
    List<Car> cars = DataSource.carList();

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
    protected String getCarHeader() {
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
