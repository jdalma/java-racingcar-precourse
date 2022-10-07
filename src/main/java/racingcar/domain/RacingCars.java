package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
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

    public String finish() {
        if (cars.size() <= 0) {
            return "";
        }
        Collections.sort(cars);
        StringBuilder result = new StringBuilder();
        int maxScore = cars.get(0).getForwardCount();
        for (Car car : cars) {
            result.append(car.toStringIfWinner(maxScore)).append("\n");
        }
        return result.toString();
    }
}
