package lotto.domain;

import lotto.util.LottoValidator;
import lotto.util.RandomNumberGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Lottos {
    private static final int LOTTO_PURCHASE_RULE_AMOUNT = 1000;
    private final List<Lotto> lottos;
    private static final Map<MatchKey, MatchCount> MATCH_TABLE = createMatchTable();

    public Lottos(int amount) {
        LottoValidator.validateAmount(amount);
        this.lottos = IntStream.range(0, amount/LOTTO_PURCHASE_RULE_AMOUNT)
                .mapToObj(i -> new Lotto(RandomNumberGenerator.generate()))
                .toList();
    }

    public int getLottoQuantity() {
        return lottos.size();
    }

    public void evaluateResults(WinningSet winningSet) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningSet);
            Boolean bonusMatch = lotto.isBonusNumberMatched(winningSet);
            MatchCount result = MATCH_TABLE.getOrDefault(new MatchKey(matchCount, bonusMatch.compareTo(false)), null);

            if (result != null) {
                result.increaseMatchCount();
            }
        }
    }

    public static Map<MatchKey, MatchCount> createMatchTable() {
        Map<MatchKey, MatchCount> table = new HashMap<>();
        table.put(new MatchKey(3, 0), MatchCount.THREE);
        table.put(new MatchKey(4, 0), MatchCount.FOUR);
        table.put(new MatchKey(5, 0), MatchCount.FIVE);
        table.put(new MatchKey(5, 1), MatchCount.FIVE_AND_BONUS);
        table.put(new MatchKey(6, 0), MatchCount.SIX);
        return table;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto.toString()).append("\n"));
        return sb.toString();
    }
}
