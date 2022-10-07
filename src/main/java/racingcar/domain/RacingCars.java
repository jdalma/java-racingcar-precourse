package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(String name) {
        this.cars = separateNameAndMakeCars(name);
    }

    public boolean isEqualNumberOfCar(int number) {
        return this.cars.size() == number;
    }

    public String finish(WinnerCondition condition) {
        if (cars.size() <= 0) {
            return "";
        }
        return condition.getWinners(this.cars, getMaxForwardCount());
    }

    private int getMaxForwardCount() {
        int max = 0;
        for (Car car : this.cars) {
            max = Math.max(max, car.getForwardCount());
        }
        return max;
    }

    private List<Car> separateNameAndMakeCars(String name) {
        List<Car> cars = new ArrayList<>();
        String[] names = name.split(",");

        for (String separatedName : names) {
            cars.add(new Car(separatedName));
        }

        return cars;
    }
}
