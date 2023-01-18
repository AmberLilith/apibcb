package com.br.momento.aprendizado.momento.aprendizado.services;

import com.br.momento.aprendizado.momento.aprendizado.RateFeign;
import com.br.momento.aprendizado.momento.aprendizado.Serie;
import com.br.momento.aprendizado.momento.aprendizado.models.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RatesService {

    @Autowired
    private RateFeign rateFeign;

    public Map<String, List<Map<String, Double>>> getSeries(
            List<Serie> series, String initialDate, String finalDate) {
        Map<String, List<Map<String, Double>>> mapWithRates = new HashMap<>();


        for (int i = 0; i < series.size(); i++) {
            if (i == 0) {
                List<Rate> firstRate = rateFeign.getRates(series.get(0).getSerie(), initialDate, finalDate);
                for (Rate rate : firstRate) {
                    List<Map<String, Double>> listMap = new ArrayList<>();
                    mapWithRates.put(rate.getData(), listMap);
                }
            }

            List<Rate> rates = rateFeign.getRates(series.get(i).getSerie(), initialDate, finalDate);

            for (Rate rate : rates) {
                Map<String, Double> map1 = new HashMap<>();
                map1.put(series.get(i).getName(), rate.getValor());
                mapWithRates.get(rate.getData()).add(map1);
            }

        }

        return mapWithRates;
    }

}
