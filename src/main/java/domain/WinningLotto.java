package domain;

public class WinningLotto {
    private static final String ERROR_DUPLICATED_NUMBER = "[ERROR] 보너스 볼은 당첨 번호와 중복될 수 없습니다.";

    private final LottoTicket winningNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(LottoTicket winningNumbers, LottoNumber bonusBall) {
        validateBonusBall(winningNumbers, bonusBall);
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    private void validateBonusBall(LottoTicket winningNumbers, LottoNumber bonusBall) {
        if (winningNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_NUMBER);
        }
    }

    public Rank calculateRank(LottoTicket lottoTicket) {
        long match = lottoTicket.numbers().stream()
                .filter(this.winningNumbers::contains)
                .count();
        boolean hasBonus = lottoTicket.contains(this.bonusBall);
        return Rank.from(match, hasBonus);
    }
}
