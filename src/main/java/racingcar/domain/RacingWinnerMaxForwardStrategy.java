package racingcar.domain;

import java.util.List;

public class RacingWinnerMaxForwardStrategy implements WinnerCondition {

    @Override
    public String getWinners(List<Car> cars, int maxForwardCount) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.toStringIfWinner(maxForwardCount)).append("\n");
        }
        return result.toString();
    }
}
