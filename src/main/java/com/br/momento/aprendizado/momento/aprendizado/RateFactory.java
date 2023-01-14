package com.br.momento.aprendizado.momento.aprendizado;

import com.br.momento.aprendizado.momento.aprendizado.models.DefaultRate;
import com.br.momento.aprendizado.momento.aprendizado.models.Rate;
import com.br.momento.aprendizado.momento.aprendizado.models.AverageInterestRate;

import java.util.ArrayList;
import java.util.List;

public class RateFactory {

    public static List<?> convertToSerieList(List<Rate> rates, String serie){
        List<Object> newList = new ArrayList<>();
        rates.forEach(rate -> {
            var serieRate = switch (serie) {
                case "20744" -> new AverageInterestRate(rate.getData(), rate.getValor());
                case "21116" -> new DefaultRate(rate.getData(), rate.getValor());
                default -> new Object();
            };

            newList.add(serieRate);

        });

        return newList;
    }

}
