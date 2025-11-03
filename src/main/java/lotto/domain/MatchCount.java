package lotto.domain;

public enum MatchCount {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_AND_BONUS(30000000),
    SIX(2000000000);

    private final int prize;
    private int matchCount = 0;

    MatchCount(int prize) {
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void increaseMatchCount() {
        this.matchCount++;
    }

    public String getDisplayText() {
        return switch (this) {
            case THREE -> String.format("3개 일치 (%,d원) - %d개", prize, matchCount);
            case FOUR -> String.format("4개 일치 (%,d원) - %d개", prize, matchCount);
            case FIVE -> String.format("5개 일치 (%,d원) - %d개", prize, matchCount);
            case FIVE_AND_BONUS -> String.format("5개 일치, 보너스 볼 일치 (%,d원) - %d개", prize, matchCount);
            case SIX -> String.format("6개 일치 (%,d원) - %d개", prize, matchCount);
        };
    }

    public int getTotalPrize() {
        return prize * matchCount;
    }
}
