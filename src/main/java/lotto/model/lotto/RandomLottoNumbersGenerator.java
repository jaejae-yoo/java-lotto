package lotto.model.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomLottoNumbersGenerator {
    private static final int LOTTO_SIZE = 6;

    public static List<Integer> pickSixNumbers() {
        List<Integer> shuffledNumbers = shuffleLottoNumbers(LottoNumbers.getNumbers());
        return Collections.unmodifiableList(shuffledNumbers
                .stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList()));
    }

    private static List<Integer> shuffleLottoNumbers(Set<Integer> numbers) {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.addAll(numbers);
        Collections.shuffle(randomNumbers);
        return randomNumbers;
    }
}
