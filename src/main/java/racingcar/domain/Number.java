package racingcar.domain;

import static racingcar.domain.RacingCarRule.NUMBER_TO_TRY_EXCEPTION;

public class Number {
    public static final String ONLY_NUMBER_REGEX = "^[0-9]+";
    private final int number;

    public Number(String line) {
        if (isContainsNonNumeric(line)) {
            throw new IllegalArgumentException(NUMBER_TO_TRY_EXCEPTION);
        }
        this.number = Integer.parseInt(line);
    }

    public boolean isEqual(int number) {
        return this.number == number;
    }

    private boolean isContainsNonNumeric(String line) {
        return !line.matches(ONLY_NUMBER_REGEX);
    }
}
