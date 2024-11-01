package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Seller {
    private final String PAY_PATTERN = "^[1-9][0-9]{3,}";
    private List<Lotto> lottoTickets = new ArrayList<>();

    public void validate(String input) {
        Pattern patternPay = Pattern.compile(PAY_PATTERN);
        Matcher matcherPay = patternPay.matcher(input);

        if (!matcherPay.matches()) {
            reject();
        }

        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            reject();
        }
    }

    public void createLottoTickets(int money) {
        int howmany = money / 1000;

        for (int i = 0; i < howmany; i++) {
            lottoTickets.add(new Lotto(getRandomNumber()));
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void reject() {
        throw new IllegalArgumentException();
    }
}