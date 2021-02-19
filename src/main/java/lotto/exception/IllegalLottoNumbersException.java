package lotto.exception;

import lotto.view.ErrorView;

public class IllegalLottoNumbersException extends IllegalArgumentException {
    public IllegalLottoNumbersException() {
        ErrorView.printIllegalLottoNumbersMessage();
    }
}
