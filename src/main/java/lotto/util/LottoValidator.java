package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class LottoValidator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_PURCHASE_UNIT = 1000;

    private LottoValidator() {}

    public static void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0원보다 커야 합니다.");
        }
        if (amount % LOTTO_PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력하여야 합니다.");
        }
    }

    public static void validateNumbers(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        boolean invalid = numbers.stream().anyMatch(n -> n < MIN_NUMBER || n > MAX_NUMBER);
        if (invalid) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
