package lotto.domain;

import lotto.util.LottoValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateNumbers(numbers);
        this.numbers = createdSortedCopy(numbers);
    }

    private List<Integer> createdSortedCopy(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return List.copyOf(sortedNumbers);
    }

    public int countMatchingNumbers(WinningSet winningSet) {
        return (int) numbers.stream()
                .filter(winningSet.getWinningNumbers()::contains)
                .count();
    }

    public boolean isBonusNumberMatched(WinningSet winningSet) {
        return numbers.contains(winningSet.getBonusNumber());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
