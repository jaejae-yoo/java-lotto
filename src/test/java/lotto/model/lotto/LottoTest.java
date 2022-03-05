package lotto.model.lotto;

import java.util.*;

import lotto.dto.WinningLottoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.entry;

import lotto.model.lotto.result.WinningResult;
import lotto.model.lotto.result.Rank;

class LottoTest {
    private WinningResult winningResult;
    private final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    @BeforeEach
    void init() {
        winningResult = new WinningResult();
    }

    @Test
    @DisplayName("당첨 번호와 로또의 비교값이 5인 경우")
    void compareWinningNumberWithLottoFive() {
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 7), 8);
        WinningLottoResponse winningNumberResponse = new WinningLottoResponse(winningLotto);
        lotto.calcWinningNumber(winningResult, winningNumberResponse);

        assertThat(winningResult.getWinningCount().get(Rank.FIVE)).isOne();
        assertThat(winningResult.getWinningCount().get(Rank.BONUS)).isZero();
    }

    @Test
    @DisplayName("당첨 번호와 로또의 비교값이 5이고, 보너스가 존재하는 경우")
    void compareWinningNumberWithLotto() {
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 8), 6);
        WinningLottoResponse winningNumberResponse =
                new WinningLottoResponse(winningLotto);
        lotto.calcWinningNumber(winningResult, winningNumberResponse);

        Assertions.assertThat(winningResult.getWinningCount()).contains(entry(Rank.BONUS, 1));
    }
}
