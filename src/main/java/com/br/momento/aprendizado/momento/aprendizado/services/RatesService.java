package com.br.momento.aprendizado.momento.aprendizado.services;

import com.br.momento.aprendizado.momento.aprendizado.RateFactory;
import com.br.momento.aprendizado.momento.aprendizado.RateFeign;
import com.br.momento.aprendizado.momento.aprendizado.models.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatesService {

    @Autowired
    private RateFeign taxaFeign;

    public List<?> getRates(String serie, String initialDate, String finalDate){
       List<Rate> rates = taxaFeign.getRates(serie, initialDate, finalDate);
        return RateFactory.convertToSerieList(rates, serie);
    }
}
