package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Utils {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    public static List<Integer> getLottoNumber() {
        return getRandomNumber(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
    }

    public static int strToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static String[] separateStr(String input, String separator) {
        return input.split(separator);
    }

    private static List<Integer> getRandomNumber(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
