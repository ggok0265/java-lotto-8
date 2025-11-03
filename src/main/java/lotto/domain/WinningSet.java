package lotto.domain;

import lotto.util.WinningSetValidator;

import java.util.List;

public class WinningSet {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void addNumbers(List<Integer> winningNumbers) {
        WinningSetValidator.validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void addBonusNumber(int bonusNumber) {
        WinningSetValidator.validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
