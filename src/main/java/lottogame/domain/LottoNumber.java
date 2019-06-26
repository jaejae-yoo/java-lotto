package lottogame.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private int lottoNumber;

    static {
        for (int lottoNumber = MIN_LOTTO_NUMBER; lottoNumber <= MAX_LOTTO_NUMBER; lottoNumber++) {
            lottoNumbers.put(lottoNumber, new LottoNumber(lottoNumber));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        return lottoNumbers.get(lottoNumber);
    }

    private static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new InvalidLottoNumberException("올바른 로또 번호가 아닙니다.");
        }
    }

    static LottoNumber getRandomLottoNumber() {
        Random random = new Random();
        return lottoNumbers.get(random.nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }
}