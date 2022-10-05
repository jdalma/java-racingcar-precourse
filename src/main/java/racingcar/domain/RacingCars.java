package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(String name) {
        this.cars = separateNameAndMakeCars(name);
    }

    private List<Car> separateNameAndMakeCars(String name) {
        List<Car> cars = new ArrayList<>();
        String[] names = name.split(",");

        for (String separatedName : names) {
            cars.add(new Car(separatedName));
        }

        return cars;
    }

    public boolean isEqualNumberOfCar(int number) {
        return this.cars.size() == number;
    }

    public String getAllCarsPrint() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.print()).append("\n");
        }
        return sb.toString();
    }
}
