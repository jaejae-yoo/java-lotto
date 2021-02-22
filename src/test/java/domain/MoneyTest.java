package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("같은 금액일 경우 정상 처리된다.")
    @Test
    public void equalsTest() {
        Money first = new Money(1_000);
        Money second = new Money(1_000);

        assertThat(first).isEqualTo(second);
    }

    @DisplayName("음수가 입력된 경우 예외를 발생시킨다.")
    @Test
    public void validatePositiveNumber() {
        assertThatThrownBy(() -> new Money(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
