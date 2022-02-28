package lotto.model.lotto;

import java.util.List;

import lotto.model.bonusball.BonusBallResponse;
import lotto.model.result.RateOfReturn;
import lotto.model.bonusball.BonusBall;
import lotto.model.result.WinningResult;
import lotto.model.winningnumber.LottoWinningNumber;
import lotto.model.winningnumber.LottoWinningNumberResponse;

public class LottoGame {
    private LottoStorage lottoStorage;
    private RateOfReturn rateOfReturn;
    private LottoWinningNumber lottoWinningNumber;
    private BonusBall bonusBall;

    public LottoStorage makeLottos(String input) {
        LottoCount lottoCount = new LottoCount(input);
        storeMoneyInRateOfReturn(input);
        lottoStorage = new LottoStorage(lottoCount);
        return lottoStorage;
    }

    private void storeMoneyInRateOfReturn(String money) {
        rateOfReturn = new RateOfReturn(money);
    }

    public void storeWinningNumber(List<String> input) {
        lottoWinningNumber = new LottoWinningNumber(input);
    }

    public void storeBonusBall(String input) {
        bonusBall = new BonusBall(input);
        lottoWinningNumber.validateReduplicationWithBonusBall(input);
    }

    public WinningResult calcLottoWithWinningNumber() {
        return lottoStorage.calcWinningNumber(new BonusBallResponse(bonusBall.getNumber()),
                new LottoWinningNumberResponse(lottoWinningNumber.getWinningNumbers()));
    }

    public double sendRateOfReturn(WinningResult winningResult) {
        return rateOfReturn.calcRateOfReturn(winningResult);
    }
}