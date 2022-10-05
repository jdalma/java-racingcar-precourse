package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.RacingCarRule.NAME_LENGTH_EXCEPTION;
import static racingcar.domain.RacingCarRule.NAME_NULL_EXCEPTION;

class RacingCarsTest {

    @Nested
    @DisplayName("RacingCars 생성자는")
    class Describe_RacingCarsConstructor {

        @Nested
        @DisplayName("자동차의 이름들을 [,]구분하여 전달한다면")
        class Context_SeparateName {

            @Nested
            @DisplayName("각 이름들이 6글자 미만이라면")
            class Context_NameSizeLessThanSix {

                private final String carNames = "aaa,bbbb,cc,d,eee,ffff";

                @Test
                @DisplayName("[,]로 구분된 만큼 자동차를 생성한다.")
                void It_MakeCars() {
                    final int namesLength = carNames.split(",").length;
                    final RacingCars racingCars = new RacingCars(carNames);

                    assertThat(racingCars.isEqualNumberOfCar(namesLength)).isTrue();
                }
            }

            @Nested
            @DisplayName("자동차 이름이 공백이라면")
            class Context_NameIsWhitespace {

                private final String carNames = "aa,,b,cccc";

                @Test
                @DisplayName("자동차 이름을 입력하라는 예외를 던진다.")
                void It_ThrowException() {
                    assertThatThrownBy(() -> new RacingCars(carNames))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(NAME_NULL_EXCEPTION);
                }
            }

            @Nested
            @DisplayName("자동차 이름 사이즈가 6 이상이라면")
            class Context_NameIsOverLength {

                private final String carNames = "aaaa,bbbbbb,cccc";

                @Test
                @DisplayName("자동차 이름의 사이즈를 확인하라는 예외를 던진다.")
                void It_ThrowException() {
                    assertThatThrownBy(() -> new RacingCars(carNames))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(NAME_LENGTH_EXCEPTION);
                }
            }
        }
    }

    @Nested
    @DisplayName("getAllCarsPrint()")
    class Describe_GetAllCarsPrintMethod {

        @Nested
        @DisplayName("자동차들이 존재한다면")
        class Context_ExistedCars {

            private final String carName = "aaa,bbb,cccc,dd,e";
            private final RacingCars racingCars = new RacingCars(carName);

            @Test
            @DisplayName("{자동차 이름} : {전진한 대시 수} 형식으로 문자열을 반환한다.")
            void It_PrintCar() {
                String[] names = carName.split(",");
                String[] carsPrint = racingCars.getAllCarsPrint().split("\n");
                for (int i = 0; i < names.length; i++) {
                    String expect = String.format("%s : ", names[i]);
                    assertThat(carsPrint[i]).isEqualTo(expect);
                }
            }
        }
    }
}
