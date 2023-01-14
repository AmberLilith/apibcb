package com.br.momento.aprendizado.momento.aprendizado.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class AllRates {

    @JsonProperty("data")
    private String date;

    @JsonProperty("taxaMediaJuros")
    private Double averageInterestRate;

    @JsonProperty("taxaInadimplencia")
    private Double defaultRate;

    public static List<AllRates> joinRates(List<?> averageInterestRate, List<?> defaultRate) {
        List<AllRates> allRatesList = new ArrayList<>();
        Iterator<?> averageInterestRateIterator = averageInterestRate.iterator();
        Iterator<?> defaultRateIterator = defaultRate.iterator();

        while (averageInterestRateIterator.hasNext() && defaultRateIterator.hasNext()) {
            AllRates allRates = new AllRates();
            BeanUtils.copyProperties(averageInterestRateIterator.next(), allRates);
            BeanUtils.copyProperties(defaultRateIterator.next(), allRates);
            allRatesList.add(allRates);
        }

        return allRatesList;
    }

}

