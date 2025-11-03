package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    private static final String INPUT_MESSAGE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String INPUT_DELIMITER = ",";

    private InputView() {
    }

    public static String inputAmount() {
        System.out.println(INPUT_MESSAGE_AMOUNT);
        return Console.readLine();
    }

    public static String[] inputLottoNumbers() {
        System.out.println(INPUT_MESSAGE_LOTTO_NUMBERS);
        return Console.readLine().split(INPUT_DELIMITER);
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_MESSAGE_BONUS_NUMBER);
        return Console.readLine();
    }
}
