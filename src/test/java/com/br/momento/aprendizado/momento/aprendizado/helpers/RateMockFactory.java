package com.br.momento.aprendizado.momento.aprendizado.helpers;

import com.br.momento.aprendizado.momento.aprendizado.models.Rate;

import java.util.ArrayList;
import java.util.List;

public class RateMockFactory {

    public static List<Rate> createListOfRate() {
        List<Rate> rates = new ArrayList<>();
        var rate1 = new Rate("01/01/2022", 4.5);
        var rate2 = new Rate("01/02/2022", 5.5);
        var rate3 = new Rate("01/03/2022", 6.5);
        rates.add(rate1);
        rates.add(rate2);
        rates.add(rate3);
        return rates;
    }

}
