package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        Lottos lottos = getLottos();
        OutputView.printPurchaseQuantity(lottos);
    }

    private Lottos getLottos() {
        return new Lottos(readValidAmount());
    }

    private int readValidAmount() {
        while (true) {
            try {
                int amount = parseInt(InputView.inputAmount());
                LottoValidator.validateAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
