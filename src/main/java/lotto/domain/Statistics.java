package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Statistics {
    private final Lottos lottos;
    private final WinningSet winningSet;

    public Statistics(Lottos lottos, WinningSet winningSet) {
        this.lottos = lottos;
        this.winningSet = winningSet;
        calculate();
    }

    private void calculate() {
        lottos.evaluateResults(winningSet);
    }

    public String getStatisticsText() {
        return Arrays.stream(MatchCount.values())
                .map(MatchCount::getDisplayText)
                .collect(Collectors.joining("\n"));
    }

    public int getTotalPrize() {
        return Arrays.stream(MatchCount.values())
                .mapToInt(MatchCount::getTotalPrize)
                .sum();
    }

    public double getProfitRate() {
        int purchaseAmount = lottos.getLottoQuantity() * 1000;
        return (double) getTotalPrize() / purchaseAmount * 100;
    }
}
