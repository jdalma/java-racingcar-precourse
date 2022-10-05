package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.RacingCarRule.NAME_LENGTH_EXCEPTION;
import static racingcar.domain.RacingCarRule.NAME_NULL_EXCEPTION;

class CarTest {

    @Nested
    @DisplayName("Car 생성자는")
    class Describe_CarConstructor{

        @Nested
        @DisplayName("자동차 이름이 null이라면")
        class Context_NameIsNull{

            @Test
            @DisplayName("자동차 이름을 입력하라는 예외를 던진다.")
            void It_ThrowException(){
                assertThatThrownBy(() -> new Car(null))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NAME_NULL_EXCEPTION);
            }
        }

        @Nested
        @DisplayName("자동차 이름이 6글자 이상이라면")
        class Context_NameIsOverLength{

            private final String name = "abcdef";

            @Test
            @DisplayName("자동차 이름 길이를 확인하라는 예외를 던진다.")
            void It_ThrowException(){
                assertThatThrownBy(() -> new Car(name))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NAME_LENGTH_EXCEPTION);
            }
        }

        @Nested
        @DisplayName("자동차 이름이 1글자 이상 5글자 이하라면")
        class Context_NameLengthIsValid{

            private final String fiveLengthName = "abcde";

            @Test
            @DisplayName("객체를 생성한다.")
            void It_MakeObject(){
                Car car = new Car(fiveLengthName);

                assertThat(car.getName()).isEqualTo(fiveLengthName);
            }
        }
    }

    @Nested
    @DisplayName("moveForward()")
    class Describe_MoveForwardMethod{

        private final Car car = new Car("test");
        private final int forward = 5;

        @Test
        @DisplayName("호출 횟수만큼 전진한다.")
        void It_CarMoveForward(){
            for (int i = 1; i <= forward; i++) {
                assertThat(car.moveForward()).isEqualTo(i);
            }
        }
    }

    @Nested
    @DisplayName("print()")
    class Describe_PrintMethod{

        private final String name = "abcde";
        private final int forward = 5;
        private final String expect = String.format("%s : %s", name, "-----");
        private Car car = new Car(name);

        @BeforeEach
        void setUp() {
            for (int i = 1; i <= forward; i++) {
                car.moveForward();
            }
        }

        @Test
        @DisplayName("'{자동차 이름} : {전진 횟수 대시}' 형식으로 출력한다.")
        void It_Print(){
            assertThat(car.print()).isEqualTo(expect);
        }
    }
}
