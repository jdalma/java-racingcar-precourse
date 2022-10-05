package racingcar.domain;

public class RacingCarRule {

    public static final int CAR_NAME_LENGTH = 5;
    public static final String ERROR = "[ERROR]";
    public static final String NAME_NULL_EXCEPTION = String.format("%s 자동차 이름을 입력하여 주세요.", ERROR);
    public static final String NAME_LENGTH_EXCEPTION = String.format("%s 자동차 이름은 1글자 이상, 5글자 이하로 작셩하여 주세요.", ERROR);

}
