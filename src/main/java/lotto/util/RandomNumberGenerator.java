package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {
    private static final int RANDOM_RANGE_START_INCLUSIVE = 1;
    private static final int RANDOM_RANGE_END_INCLUSIVE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_RANGE_START_INCLUSIVE,
                RANDOM_RANGE_END_INCLUSIVE, LOTTO_NUMBER_COUNT);
    }
}
