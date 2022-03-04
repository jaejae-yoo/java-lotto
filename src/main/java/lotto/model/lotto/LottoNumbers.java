package lotto.model.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final Set<Integer> numbers = new HashSet<>();
    static final int MIN = 1;
    static final int MAX = 45;

    static {
        IntStream.range(MIN, MAX)
                .forEach(numbers::add);
    }

    private LottoNumbers() {
    }

    static Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
}
