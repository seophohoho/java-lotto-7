package lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.Utils;
import lotto.view.Error;

public class BonusNumber {
    private static final String BONUS_NUMBER_PATTERN = "[1-9][0-9]{0,1}";
    private int number;

    public void validate(String input) {
        Pattern patternBonusNumber = Pattern.compile(BONUS_NUMBER_PATTERN);
        Matcher matcher = patternBonusNumber.matcher(input);

        if (!matcher.matches()) {
            Error.reject(Error.INVALID_MSG);
        }

        if (!Utils.isContainInRange(input, Utils.MIN_LOTTO_NUMBER, Utils.MAX_LOTTO_NUMBER)) {
            Error.reject(Error.RANGE_MSG);
        }
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
