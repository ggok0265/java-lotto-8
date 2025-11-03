package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Statistics;

public final class OutputView {
    private static final String OUTPUT_MESSAGE_PURCHASE_QUANTITY = "\n%d개를 구매했습니다.\n";
    private static final String OUTPUT_MESSAGE_LOTTO_STATS = "당첨 통계\n---";
    private static final String OUTPUT_MESSAGE_TOTAL_PROFIT = "총 수익률은 %.1f%%입니다.\n";
    private static final String ERROR_PREFIX = "[ERROR] ";

    private OutputView() {
    }

//    public static void printPurchaseQuantity() {
//        System.out.printf(OUTPUT_MESSAGE_PURCHASE_QUANTITY, );
//        System.out.println();
//    }
//
//    public static void printWinningStatistics() {
//        System.out.println(OUTPUT_MESSAGE_LOTTO_STATS);
//        System.out.println();
//        System.out.printf(OUTPUT_MESSAGE_TOTAL_PROFIT, );
//    }
//
//    public static void printError(String message) {
//        System.out.println(ERROR_PREFIX + message);
//    }
}
