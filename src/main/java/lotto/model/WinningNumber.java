package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.view.Error;

public class WinningNumber {
    private static final String WINNING_NUMBER_PATTERN = "([1-9][0-9]{0,1},){5}[1-9][0-9]{0,1}";
    private final List<Integer> numbers = new ArrayList<>();

    public void validate(String input) {
        Pattern patternWinningNumber = Pattern.compile(WINNING_NUMBER_PATTERN);
        Matcher matcherPay = patternWinningNumber.matcher(input);

        if (!matcherPay.matches()) {
            Error.reject(Error.INVALID_MSG);
        }

        String[] separateWinningNumber = input.split(",");
        if (!Arrays.stream(separateWinningNumber)
                .allMatch(num -> Integer.parseInt(num) >= 1 && Integer.parseInt(num) <= 45)) {
            Error.reject(Error.RANGE_MSG);
        }

        if (Arrays.stream(separateWinningNumber).distinct().count() != separateWinningNumber.length) {
            Error.reject(Error.DUPLICATE_VALUE_MSG);
        }
    }

    public void setNumbers(String input) {
        String[] separateWinningNumber = input.split(",");

        for (int i = 0; i < separateWinningNumber.length; i++) {
            this.numbers.add(Integer.parseInt(separateWinningNumber[i]));
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
